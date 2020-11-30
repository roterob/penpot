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

  ;; WELCOME SCREEN

  ; [:div.modal-overlay
  ;  [:div.modal-container.onboarding
  ;   [:div.modal-left
  ;    [:img {:src "images/pot.png" :border "0" :alt "Penpot"}]]
  ;   [:div.modal-right
  ;    [:div.modal-title
  ;     [:h2 "Welcome to Penpot!"]]
  ;    [:span.release "Alpha version 1.0"]
  ;    [:div.modal-content
  ;     [:p "We are very happy to introduce you to the very first Alpha 1.0 release."]
  ;     [:p "Penpot is still at development stage and there will be constant updates. We hope you enjoy the first stable version."]]
  ;   [:div.modal-navigation
  ;    [:button.btn-secondary "Continue"]]]
  ;   [:img.deco {:src "images/deco-left.png" :border "0"}]
  ;   [:img.deco.right {:src "images/deco-right.png" :border "0"}]]])

  ;; OS SCREEN

  ; [:div.modal-overlay
  ;  [:div.modal-container.onboarding.black
  ;   [:div.modal-left
  ;    [:img {:src "images/open-source.svg" :border "0" :alt "Open Source"}]]
  ;   [:div.modal-right
  ;    [:div.modal-title
  ;     [:h2 "Contribute to the project"]]
  ;    [:div.modal-content
  ;     [:p "Penpot is made by and for the community."]
  ;     [:p "If you want to collaborate, you are welcome to do so !!! You can access our project on github and follow the contribution instructions :)"]]
  ;   [:div.modal-navigation
  ;    [:button.btn-secondary "Continue"]]]]])

  ;; FEATURE SCREEN

  [:div.modal-overlay
   [:div.modal-container.onboarding.feature
    [:div.modal-left
     [:img {:src "images/test-gif.gif" :border "0" :alt "Feature name"}]]
    [:div.modal-right
     [:div.modal-title
      [:h2 "Design with components"]]
     [:div.modal-content
      [:p "Create beautiful user interfaces in collaboration with all team members."]
      [:p "Maintain consistency at scale with components, libraries and design systems."]]
    [:div.modal-navigation
     [:button.btn-secondary "Continue"]
     [:span.skip "Skip"]
     [:ul.step-dots
      [:li.current]
      [:li]
      [:li]
      [:li]]]]]])
