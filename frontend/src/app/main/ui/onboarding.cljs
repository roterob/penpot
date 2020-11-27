;; This Source Code Form is subject to the terms of the Mozilla Public
;; License, v. 2.0. If a copy of the MPL was not distributed with this
;; file, You can obtain one at http://mozilla.org/MPL/2.0/.
;;
;; This Source Code Form is "Incompatible With Secondary Licenses", as
;; defined by the Mozilla Public License, v. 2.0.
;;
;; Copyright (c) 2020 UXBOX Labs SL

(ns app.main.ui.onboarding
  (:require
   [app.main.data.modal :as modal]
   [rumext.alpha :as mf]))

(mf/defc onboarding-modal
  {::mf/register modal/components
   ::mf/register-as :onboarding}
  [props]
  [:div.modal-overlay
   [:div.modal-container.onboarding
    [:div.modal-header
     [:div.modal-header-title
      [:h2 "title"]]]

    [:div.modal-content
     [:span "content"]]

    [:div.modal-footer
     [:div.action-buttons
      [:button.btn-warning.btn-large "accept"]
      [:button.btn-secondary.btn-large "cancel"]]]]])

