(global["webpackJsonp"]=global["webpackJsonp"]||[]).push([["pages/complete/index"],{49:function(e,n,t){"use strict";(function(e,n){var a=t(4);t(26);a(t(25));var r=a(t(50));e.__webpack_require_UNI_MP_PLUGIN__=t,n(r.default)}).call(this,t(1)["default"],t(2)["createPage"])},50:function(e,n,t){"use strict";t.r(n);var a=t(51),r=t(53);for(var i in r)["default"].indexOf(i)<0&&function(e){t.d(n,e,(function(){return r[e]}))}(i);t(55);var o,u=t(32),c=Object(u["default"])(r["default"],a["render"],a["staticRenderFns"],!1,null,null,null,!1,a["components"],o);c.options.__file="pages/complete/index.vue",n["default"]=c.exports},51:function(e,n,t){"use strict";t.r(n);var a=t(52);t.d(n,"render",(function(){return a["render"]})),t.d(n,"staticRenderFns",(function(){return a["staticRenderFns"]})),t.d(n,"recyclableRender",(function(){return a["recyclableRender"]})),t.d(n,"components",(function(){return a["components"]}))},52:function(e,n,t){"use strict";var a;t.r(n),t.d(n,"render",(function(){return r})),t.d(n,"staticRenderFns",(function(){return o})),t.d(n,"recyclableRender",(function(){return i})),t.d(n,"components",(function(){return a}));var r=function(){var e=this,n=e.$createElement;e._self._c},i=!1,o=[];r._withStripped=!0},53:function(e,n,t){"use strict";t.r(n);var a=t(54),r=t.n(a);for(var i in a)["default"].indexOf(i)<0&&function(e){t.d(n,e,(function(){return a[e]}))}(i);n["default"]=r.a},54:function(e,n,t){"use strict";(function(e){var a=t(4);Object.defineProperty(n,"__esModule",{value:!0}),n.default=void 0;var r=a(t(39)),i=(a(t(43)),{created:function(){e.getSystemInfoSync().statusBarHeight;var n=e.getMenuButtonBoundingClientRect();n&&(this.navBarTop=n.top,this.navBarHeight=n.height)},onLoad:function(n){e.showShareMenu({withShareTicket:!0,menus:["shareAppMessage","shareTimeline"]}),void 0==n.examId||""==n.examId?this.examId=5:this.examId=n.examId,this.showExam()},onShareAppMessage:function(e){return{title:"我答对了 "+this.exam.correct+" 道题 , 快来试试你能答对几道题吧！",path:"pages/home/index"}},onShareTimeline:function(){return{title:"我答对了 "+this.exam.correct+" 道题 , 快来试试你能答对几道题吧！",imageUrl:"https://shop.julywhj.cn/2023/garbage/shareQr.jpg"}},data:function(){return{navBarTop:0,navBarHeight:0,examId:4,exam:{}}},methods:{showExam:function(){var e=this;r.default.get("/exam/showExamContent",{examId:this.examId},{login:!1}).then((function(n){e.exam=n.data.data,e.examId=n.data.data.id}))},showAnswer:function(){e.navigateTo({url:"/pages/showAnswer/index?examId="+this.examId})},backHome:function(){e.reLaunch({url:"/pages/home/index"})},handelAgain:function(){e.navigateTo({url:"/pages/exam/index"})}}});n.default=i}).call(this,t(2)["default"])},55:function(e,n,t){"use strict";t.r(n);var a=t(56),r=t.n(a);for(var i in a)["default"].indexOf(i)<0&&function(e){t.d(n,e,(function(){return a[e]}))}(i);n["default"]=r.a},56:function(e,n,t){}},[[49,"common/runtime","common/vendor"]]]);
//# sourceMappingURL=../../../.sourcemap/mp-weixin/pages/complete/index.js.map