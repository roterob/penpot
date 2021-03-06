;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/.
;;
;; This Source Code Form is "Incompatible With Secondary Licenses", as
;; defined by the Mozilla Public License, v. 2.0.
;;
;; Copyright (c) 2020 UXBOX Labs SL

(ns app.services.mutations.viewer
  (:require
   [app.common.exceptions :as ex]
   [app.common.pages :as cp]
   [app.common.spec :as us]
   [app.config :as cfg]
   [app.db :as db]
   [app.services.mutations :as sm]
   [app.services.queries.files :as files]
   [buddy.core.codecs :as bc]
   [buddy.core.nonce :as bn]
   [clojure.spec.alpha :as s]))

(s/def ::profile-id ::us/uuid)
(s/def ::file-id ::us/uuid)
(s/def ::page-id ::us/uuid)

(s/def ::create-file-share-token
  (s/keys :req-un [::profile-id ::file-id ::page-id]))

(sm/defmutation ::create-file-share-token
  [{:keys [profile-id file-id page-id] :as params}]
  (db/with-atomic [conn db/pool]
    (files/check-edition-permissions! conn profile-id file-id)
    (let [token (-> (bn/random-bytes 16)
                    (bc/bytes->b64u)
                    (bc/bytes->str))]
      (db/insert! conn :file-share-token
                  {:file-id file-id
                   :page-id page-id
                   :token token})
      {:token token})))


(s/def ::token ::us/not-empty-string)
(s/def ::delete-file-share-token
  (s/keys :req-un [::profile-id ::file-id ::token]))

(sm/defmutation ::delete-file-share-token
  [{:keys [profile-id file-id token]}]
  (db/with-atomic [conn db/pool]
    (files/check-edition-permissions! conn profile-id file-id)
    (db/delete! conn :file-share-token
                {:file-id file-id
                 :token token})
    nil))
