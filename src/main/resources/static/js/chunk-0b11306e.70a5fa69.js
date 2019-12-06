(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-0b11306e"],{"0f9e":function(e,o,t){"use strict";t.r(o);var r=function(){var e=this,o=e.$createElement,t=e._self._c||o;return t("div",{staticClass:"register-container"},[t("Sign",{scopedSlots:e._u([{key:"form",fn:function(){return[t("h3",[e._v("注册")]),t("el-form",{ref:"form",attrs:{model:e.form,rules:e.rules,disabled:e.registerDisabled}},[t("el-form-item",{attrs:{prop:"account"}},[t("el-input",{attrs:{placeholder:"请输入账号"},model:{value:e.form.account,callback:function(o){e.$set(e.form,"account",o)},expression:"form.account"}})],1),t("el-form-item",{attrs:{prop:"password"}},[t("el-input",{attrs:{type:"password",placeholder:"请输入密码","show-password":""},model:{value:e.form.password,callback:function(o){e.$set(e.form,"password",o)},expression:"form.password"}})],1),t("el-form-item",{attrs:{prop:"username"}},[t("el-input",{attrs:{placeholder:"请输入用户名"},model:{value:e.form.username,callback:function(o){e.$set(e.form,"username",o)},expression:"form.username"}})],1),t("el-form-item",{attrs:{prop:"email"}},[t("el-input",{attrs:{placeholder:"请输入邮箱"},model:{value:e.form.email,callback:function(o){e.$set(e.form,"email",o)},expression:"form.email"}})],1),t("el-form-item",{attrs:{prop:"checkCode"}},[t("div",{staticClass:"code-form"},[t("el-input",{attrs:{placeholder:"请输入验证码"},model:{value:e.form.checkCode,callback:function(o){e.$set(e.form,"checkCode",o)},expression:"form.checkCode"}}),t("el-button",{attrs:{plain:"",disabled:e.codeDisabled,loading:e.codeLoading},on:{click:e.sendCode}},[t("span",{directives:[{name:"show",rawName:"v-show",value:0===e.codeCount&&!e.codeLoading,expression:"codeCount===0 && !codeLoading"}]},[e._v("获取验证码")]),t("span",{directives:[{name:"show",rawName:"v-show",value:e.codeLoading,expression:"codeLoading"}]},[e._v("获取中...")]),t("span",{directives:[{name:"show",rawName:"v-show",value:e.codeCount>0,expression:"codeCount>0"}]},[e._v("稍等 "+e._s(e.codeCount)+" 秒")])])],1)]),t("el-form-item",{staticClass:"form-item-line-height",attrs:{prop:"check"}},[t("div",{staticClass:"agreement"},[t("el-checkbox",{model:{value:e.form.check,callback:function(o){e.$set(e.form,"check",o)},expression:"form.check"}},[e._v("同意遵守")]),t("el-link",{attrs:{type:"primary",underline:!1}},[e._v("《服务协议》")])],1)]),t("el-form-item",[t("el-button",{attrs:{type:"primary",loading:e.registerDisabled},on:{click:e.register}},[e._v("注册")])],1),t("p",[t("span",[e._v("已有账号？")]),t("el-link",{attrs:{type:"primary",underline:!1},on:{click:e.toLogin}},[e._v("立刻登录")])],1)],1)]},proxy:!0}])})],1)},s=[],a=t("774a"),i={name:"Register",components:{Sign:a["a"]},data:function(){return{registerDisabled:!1,codeCount:0,codeTimer:"",codeLoading:!1,form:{account:"",password:"",username:"",email:"",checkCode:"",check:!1}}},methods:{register:function(){var e=this;this.$refs.form.validate(function(o){o&&(e.registerDisabled=!0,e.axios({method:"post",url:"/register",data:{account:e.form.account,password:e.form.password,email:e.form.email,name:e.form.username,checkCode:e.form.checkCode}}).then(function(o){e.$message.success("注册成功"),e.registerDisabled=!1}).catch(function(o){e.registerDisabled=!1}))})},toLogin:function(){this.$router.push("/login")},sendCode:function(){var e=this;this.codeLoading=!0,this.axios({method:"post",url:"/getCheckCode",data:{email:this.form.email}}).then(function(o){e.codeLoading=!1,e.setCodeTimer()}).catch(function(o){e.codeLoading=!1})},setCodeTimer:function(){var e=this;clearInterval(this.codeTimer),this.codeCount=60,this.codeTimer=setInterval(function(){e.codeCount--,0===e.codeCount&&clearInterval(e.codeTimer)},1e3)}},computed:{rules:function(){var e=function(e,o,t){o?t():t(new Error("请同意遵守《服务协议》"))};return{account:[{required:!0,message:"请输入账号",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"},{min:6,message:"至少 6 位密码",trigger:"blur"}],username:[{required:!0,message:"请输入用户名",trigger:"blur"}],email:[{required:!0,message:"请输入邮箱",trigger:"blur"}],checkCode:[{required:!0,message:"请输入验证码",trigger:"blur"}],check:[{validator:e,trigger:"change"}]}},codeDisabled:function(){return!(this.form.email&&0===this.codeCount)}}},n=i,c=(t("d80b"),t("2877")),d=Object(c["a"])(n,r,s,!1,null,"199daaf8",null);o["default"]=d.exports},"4ffd":function(e,o){e.exports="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAL8AAAA4CAYAAACsXylmAAAFOUlEQVR4nO1di23bMBBluoFWUEdwRnBHSEfwCu4IzgjxCO4IyQjOCO4I9ggpBFCAYIgmqXv34SkHEDBgw9LjezodyePxKbRpmxDCNt758PnlAYqP2AY7hhBuDSIe8PXx8z6E0M385l/EN9ir4L3V2Np4g9nQUW8hhC9A28fOt2zDPb4TsJ4y4vrmjdjBXxOPxGUD4Cuo8+7b2YhARhs8+oEBo4Y1wZtV8e+ZOi7VmdpvArTox3YRxtEUb9bEv42ESXXgtL2BsVjAKyX+JnmzJH4u71fTzgKhnCReCfE3y5sF8XeA+0C262RWgstOQlg4xd88b9ri7+NTa6UDp43rAZAUDJf4XfCmKf5eMU7UegCkPSWH+N3wpiX+zrDn4HoAUPPdmuJ3xZuW+C3Firl2BYR3klOAnOJ3xZuG+C3MDtQ2ymLRRvG+keJ3x5u0+F8a7MCxHRaKRjNMQInfJW+S4u8aGCjlWu2K4k75fhHid8nbD0DH1NhOcAGJy2q8f0d4W1gyt7xJef6OMdFJupXO/mgNcpGe3y1vkp5/l8hDp9qfEMLvEMLTXXuO330yXHNf+Lsdw7UH+xux/ZzB/QuM2zVvUp4f7T1KBRjiE48edOZi/y2D5zpUCrGv7Kc5c82bhPiRMwWUxDPkVF0ulkde66KUcu2eNwnxo1Y2z4BXMCoOv2aug/JYCMxLzT1vEuJHvDovQBGgSE154w70/xflWRb3vHGLH7W6iUwwQ81bp+JXVLigucXSPW8Ssz2IWPU42cmPsBuowkEKG8Jbf8RZHS1zz5uE+BFC4BDBMZb7oFgKGwKzdvkR97y1IP4b2HtMjUoOl/g5MZeae94kxE8d7HCKgLqQ0iXwUYVTgrlnGq+M5p63Fjw/x0rfaNTXZ2CahuTEPNohE9e75006sW2JcZaps1oCT+q+Toz/bZ63FsT/bXyGSH9o1iTET31KOVc3tVZOLVmq8K173loQP2dOC2I6bw6fZeHMXWsu+9Q9by2In7N4FJWgWwIfdUAm/UaaW0l2z5uE+BFC4OpIavpAChsVM3e1uHvbzAjKPW8tiD8w5bggtualsCFCBumEtnuhuudNQvyI+d4dQ4IUYpYjhQ2xwCOd1HYvqFXwRs3qLAG3tpRmBOZrBi91hfe+zdW3+U5pJi6TI2+6pc0siCrMjxah0OKf2+junjcqSe8FN+5xO1zuQAQUWbWv+aUY58TvnjfE011SmwZd9Eh7I3Qu3EPt5irt36mhxO+eN2Rtmbf4f/sZkFw1bPaJweEmfsdRKrC0bieyKvO5cHy1NBxKid81b1zl9O4701Pxo9J6PBzlSy4PhEPxlKnxhWveuCoIz3kSCxXMqK22WnMrJb0fhVaueeN4sqViSOlWO2+tWZ68puXWFdzyxnE4Wkr8HKGAVFtadNZ6XfvcmoJr3jhqrz8qkLq2wymsl/guPcfWLW9ocnLVgdd2LJHl8KcGm0ve0LM+OfGv8UA6iwPH2tPL3fKGBFVSF36NR5FaCh1KYv3V8NYDZ35KD0Ww7Em4Mis1jiRF43PJG2rwW3MiSPPH2C8w7TcAIjXYJW+IB2DJcTgWQgJKAlataY0B0BUb3PG2JcZ1S8+Col7Xkigs4uUK5dzx1hHiU+pBaJLe5F3p5JOpcY8DzkIY3fHWL3hFo85/5ezMk8Jm8Ue2YVhtvyq80dzyto2dmQOHPPY+xGsihDFmRVo+V3Z0NpSZt7ORamxmeXtC/ZGwvUw6Ibeb/3VSTUG75v0S6ydx+vaBx/uclO4+Gq1Daoe3EMJ/7oT6/yaPbm8AAAAASUVORK5CYII="},"5c48":function(e,o,t){},"5d11":function(e,o,t){"use strict";var r=t("5e58"),s=t.n(r);s.a},"5e58":function(e,o,t){},"774a":function(e,o,t){"use strict";var r=function(){var e=this,o=e.$createElement,r=e._self._c||o;return r("div",{staticClass:"sign-container"},[r("div",{staticClass:"sign-body"},[r("div",{staticClass:"logo",on:{click:e.toHome}},[r("img",{attrs:{src:t("4ffd"),alt:"logo"}})]),e._t("form")],2)])},s=[],a={name:"Sign",methods:{toHome:function(){this.$router.push("/")}}},i=a,n=(t("5d11"),t("2877")),c=Object(n["a"])(i,r,s,!1,null,"dbbc9f76",null);o["a"]=c.exports},d80b:function(e,o,t){"use strict";var r=t("5c48"),s=t.n(r);s.a}}]);