/**
 * 字典
 * 获取字典数据：this.$store.getters.getDict('字典键')
 * 根据字典和值解析字典名称：this.$store.getters.getDictLabel('字典键', 字典值)
 * 根据字典和值解析字典对象：this.$store.getters.getDictObj('字典键', 字典值)
 */

const dict = {
	state: {
		// 箱子状态
		boxState: [
			// {value: 'FREE', label: '空闲', icon: require(''), color: '#3bc45c'},
			// {value: 'BROKEN', label: '破损', icon: require(''), color: '#3488ff'},
			// {value: 'ALREADY_SELL', label: '已销售', icon: require(''), color: '#3488ff'},
			// {value: 'LEASE', label: '租赁中', icon: require(''), color: '#3488ff'},
			// {value: 'WAITING_RECYCLING', label: '待回收', icon: require(''), color: '#3488ff'},
			// {value: 'DAMAGED', label: '破损', icon: require(''), color: '#3488ff'},
			// {value: 'CLEANING', label: '清洗中', icon: require(''), color: '#3488ff'},
			// {value: 'REPAIR', label: '维修中', icon: require(''), color: '#3488ff'},
			// {value: 'SCRAP', label: '破损报废', icon: require(''), color: '#3488ff'},
			// {value: 'STOCK', label: '库存', icon: require(''), color: '#3488ff'},
			// {value: 'DISTANCE', label: '在途', icon: require(''), color: '#3bc45c'},
			// {value: 'NORMAL', label: '正常', icon: require(''), color: '#3bc45c'},
			// {value: 'ALREADY_DELIVERY', label: '发出', icon: require(''), color: '#FF8F1F'},
		],

	},
	mutations: {
		setDict: (state, params) => {
			const {dictKey, dict} = params
			uni.setStorageSync(dictKey, JSON.stringify(dict))
			state[dictKey] = dict
		}

	},
	getters: {
		// 根据字典值获取对应名称
		getDictLabel: (state) => {
			return (dict, value) => {
				return ((state[dict]||[]).find((o) => o.value == value) || {}).label
			}
		},
		// 根据字典值获取字典对象
		getDictObj: (state) => {
			return (dict, value) => {
				return (state[dict]||[]).find((o) => o.value == value) || {}
			}
		},
		getDict: (state) => {
			return (dict) => {
				return (state[dict]||[])
			}
		}
	},


};

export default dict;
