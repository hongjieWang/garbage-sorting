// 退出登录
import store from "@/store";
export const handleLoginFailure = () => {

	console.log('————————')
	console.log('退出登录，标记当前页面为授权页面，防止多次跳转')
	console.log('————————')

	store.commit("logout");

	//token失效
	uni.reLaunch({
		url: '/pages/home/index',
	})
}
// 年月日，时分秒
// "YYYY-mm-dd HH:MM"
export function dateFormatL(fmt, date) {
	let ret;
	const opt = {
		"Y+": date.getFullYear().toString(), // 年
		"m+": (date.getMonth() + 1).toString(), // 月
		"d+": date.getDate().toString(), // 日
		"H+": date.getHours().toString(), // 时
		"M+": date.getMinutes().toString(), // 分
		"S+": date.getSeconds().toString() // 秒
		// 有其他格式化字符需求可以继续添加，必须转化成字符串
	};
	for (let k in opt) {
		ret = new RegExp("(" + k + ")").exec(fmt);
		if (ret) {
			fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
		};
	};
	return fmt;
}
export default {
	/**
	 * 封装toast
	 * @param {*} config
	 * showToast('测试')
	 * showToast({icon: 'none', title: '测试'})
	 */
	showToast(config = {}) {
		if (typeof config == 'string') {
			config = {
				title: config,
				icon: 'none'
			}
		}
		uni.showToast(config)
	},

	/**
	 * 跳转
	 * @param {config} url: 跳转的页面  type: 类型（可选：'page', 'tab'）
	 * go("/pages/home/index")
	 * go({url: '/pages/home/index'})
	 */
	 go(config = {}) {
		if (typeof config == 'string') {
			config = {
				url: config
			}
		}
		const {url, type = "page"} = config
		let options = {
			url,
			success: res => {},
			fail: res => {
				console.log("跳转失败", res)
			},
			complete: res => {}
		}
		switch (type) {
			case 'page':
				uni.navigateTo(options);
				break;
			case 'tab':
				uni.switchTab(options)
				break;
            case 'rep':
                uni.redirectTo(options);    
		}
	},

	/**
	 * 拨打电话
	 * $util.makePhoneCall('123')
	 */
	makePhoneCall(config = {}) {
		if (typeof config == 'string') {
			config = {
				phoneNumber: config
			}
		}
		uni.makePhoneCall(config);
	},

	/**
	 * 返回
	 * back()
	 * back({delta: 1})
	 *
	 */
	back(config = {}) {
		if (typeof config == 'string') {
			config = {
				delta: config || 1
			}
		}
		uni.navigateBack({
			...config
		})
	},
	/**
	 * 设置标题
	 * @param {Object} config
	 */
	setNavigationBarTitle(config) {
		if (typeof config == 'string') {
			config = {
				title: config
			}
		}
		uni.setNavigationBarTitle(config);
	},

	/**
	 * 获取上一页页面信息
	 */
	 getPrevPage() {
		return new Promise((resolve, reject) => {
			var pages = getCurrentPages();
			var Page = pages[pages.length - 1];//当前页
			var prevPage = pages[pages.length - 2];  //上一个页面
			if(prevPage) {
				resolve(prevPage)
			}
		})
	},

	// 获取地址参数
	getUrlQuery(url, name) {
	  var reg = new RegExp("(^|&|/?)"+ name +"=([^&]*)(&|$)");
	    var r = url.match(reg);
	    console.log(`链接：${url} 参数：${name} 结果：${r}`)
	    if(r!=null) {
	      let str = decodeURIComponent(r[2])
	      return isNaN(Number(str))? str: Number(str)
	    } else {
	      return null;
	    }
	},
    // 错误信息提示
    validatorDefaultCatch(err, type = "message") {
        uni.showToast({
            title: err.errors[0].message,
            icon: 'none',
            duration: 2000
        })
        return false
    }
}