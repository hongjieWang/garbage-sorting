import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);
import cookie from '@/common/cookie';


const debug = process.env.NODE_ENV !== "production";

const loginKey = "login_status";
const authorKey = 'author_status';


const vuexStore = new Vuex.Store({
	state: {
		token: cookie.get(loginKey) || '',
		author: cookie.get(authorKey) || '',
		userInfo: cookie.get('userInfo'),
		authorPhone: cookie.get('authorPhone'),
	},
	mutations:{
		login(state, token, expires_time) {
			console.log("保存token信息", token)
			state.token = token;
			cookie.set(loginKey, token, expires_time);
		},
		author(state, author, expires_time) {
			state.author = author;
			cookie.set(authorKey, author, expires_time);
		},
		logout(state) {
			console.log('清除数据')
			state.token = null;
			state.userInfo = null;
			uni.clearStorage()
			uni.clearStorageSync()
			cookie.clearAll()
		},
		updateUserInfo(state, userInfo) {
			state.userInfo = userInfo;
			if(userInfo) {
				cookie.set('userInfo', userInfo)
			} else {
				cookie.set('userInfo', null)
			}
		},
		setAuthorPhone(state, authorPhone, expires_time) {
			state.authorPhone = authorPhone;
			cookie.set('authorPhone', authorPhone, expires_time);
		},
	},
	actions: {
		changeLogin({ state, commit }, data, date) {
			commit("login", data, date);
		},
		setUserInfo({ state, commit }, user) {
			commit("updateUserInfo", user);
		},

	},
	getters: {
		token: state => state.token,
		userInfo: state => state.userInfo || {},
		authorPhone:state=>state.authorPhone
	},
	strict: debug
});

export default vuexStore