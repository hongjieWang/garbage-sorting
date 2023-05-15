<template>
	<view class="content">
		<view class="title" :style="{paddingTop:navBarTop+'px',height:navBarHeight+'px',lineHeight:navBarHeight+'px'}">
			垃圾分类鉴别</view>

		<view class="subTitle">分类让垃圾变宝，和谐让世界微笑。</view>

		<!--分类信息-->
		<view style="margin-left: 52rpx; margin-right: 52rpx; margin-top: 52rpx;">
			<view class="flex justify-between">
				<view class="category c1" @click="onclickCategory('A')"></view>
				<view class="category c3" @click="onclickCategory('B')"></view>
			</view>
			<view class="flex justify-between">
				<view class="category c2" @click="onclickCategory('C')"></view>
				<view class="category c4" @click="onclickCategory('D')"></view>
			</view>
		</view>

		<!--操作-->
		<view class="flex ml-6 mr-6 justify-between">
			<view class="saoma" style="width: 420rpx; height:200rpx;" @click="photograph">
			</view>
			<view class="wenzi" style="width: 200rpx; height:200rpx;" @click="seach"></view>
		</view>

		<view class="text-center" style="height: 280rpx;margin-top: 22rpx;">
			<image src="https://shop.julywhj.cn/2023/garbage/c_test.png" style="height: 280rpx; width: 646rpx;"></image>
		</view>
	</view>
</template>

<script>
	export default {
		created() {
			//获取手机状态栏高度
			let statusBar = uni.getSystemInfoSync().statusBarHeight;
			let meniButtonInfo = uni.getMenuButtonBoundingClientRect();
			if (meniButtonInfo) {
				this.navBarTop = meniButtonInfo.top;
				this.navBarHeight = meniButtonInfo.height;
			}
		},
		data() {
			return {
				// 状态栏高度
				navBarTop: 0,
				// 导航栏高度
				navBarHeight: 0,
				categorys: [{
						categoryNo: "A",
						categoryName: "可回收",
						categoryExplain: "废纸张、废塑料、废玻璃制品、废金属、废织物等适宜回收、可循环利用的生活废弃物",
						categoryRequire: "轻投轻放；清洁干燥，避免污染；废纸尽量平整；立体包装物请清空内容物，清洁后压扁投放；有尖锐边角的，应包裹后投放。",
						categoryCommon: "报纸、纸箱、书本、纸袋、塑料瓶、玩具、油桶、乳液罐、食品保鲜盒、衣架、酒瓶、玻璃杯、易拉罐、锅、螺丝刀、皮鞋、衣物、包、毛绒玩具、电路板、砧板、插座等。",
						bg: "https://shop.julywhj.cn/2023/garbage/cateforybg3.png",
						bgImage: "https://shop.julywhj.cn/2023/garbage/kehuishoubg1.png",
						bgImage2: "https://shop.julywhj.cn/2023/garbage/kehuishouicon.png",
						color: "#003B79"
					},
					{
						categoryNo: "B",
						categoryName: "有害垃圾",
						categoryExplain: "对人体健康或自然环境造成直接或潜在的危害废弃物",
						categoryRequire: "充电电池、纽扣电池、蓄电池投放时应注意轻放；油漆桶、杀虫剂如有残留请密闭后投放；荧光灯、节能灯易破损连带包装或包裹后投放；废药品及其包装一并投放。",
						categoryCommon: "电池类、荧光灯管类、过期药物、药品包装、过期指甲油、指甲水、染发剂壳、废油漆桶、水银体温计/血压计、消毒剂、老鼠药、杀虫喷雾、X光片、相片底片。",
						bg: "https://shop.julywhj.cn/2023/garbage/B_bg.png",
						bgImage: "https://shop.julywhj.cn/2023/garbage/B_bg2.png",
						bgImage2: "https://shop.julywhj.cn/2023/garbage/B_icon.png",
						color: "#790000"
					},
					{
						categoryNo: "C",
						categoryName: "湿垃圾",
						categoryExplain: "部分地区又称”厨余垃圾”，日常生活垃圾产生的容易腐烂的生物质废物。",
						categoryRequire: "餐厨垃圾应沥干水分后再投放，有包装物的应取出后分类投放；大块骨头和椰子壳，榴莲壳等不易生化降解，作为干垃圾进行投放；纯液体（如牛奶等），可直接倒入下水口。",
						categoryCommon: "剩饭剩菜、面包、鸡肉、干果仁、蔬菜、花卉、蛋糕饼干、动物内脏、苹果核、鸡蛋及蛋壳、大米及豆类、中药药渣、宠物饲料。",
						bg: "https://shop.julywhj.cn/2023/garbage/C_bg.png",
						bgImage: "https://shop.julywhj.cn/2023/garbage/C_bg2.png",
						bgImage2: "https://shop.julywhj.cn/2023/garbage/C_icon.png",
						color: "#663F05"
					},
					{
						categoryNo: "D",
						categoryName: "干垃圾",
						categoryExplain: "部分地区又称”其他垃圾”，除有害垃圾、可回收物、湿垃圾以外的生活废弃物。",
						categoryRequire: "尽量沥干水分；难以辨别的生活垃圾应投入干垃圾容器内。",
						categoryCommon: "餐巾纸、纸巾、纸尿裤、烟蒂、陶瓷花盆、胶带、橡皮泥、创可贴、笔、灰土、眼镜、头发、内衣裤、防碎气泡膜、旧毛巾、污损纸张、塑料袋。",
						bg: "https://shop.julywhj.cn/2023/garbage/D_bg_mini.png",
						bgImage: "https://shop.julywhj.cn/2023/garbage/D_bg2.png",
						bgImage2: "https://shop.julywhj.cn/2023/garbage/D_icon.png",
						color: "#03563C"
					}
				]
			}
		},
		methods: {
			onclickCategory(categoryNo) {
				uni.navigateTo({
					url: '/pages/category/index?categoryNo=' + categoryNo
				})
			},
			seach() {
				uni.navigateTo({
					url: '/pages/seach/index'
				})
			},
			photograph() {
				uni.chooseMedia({
					count: 1, //默认9
					mediaType: ['image'],
					sizeType: ['compressed'], //可以指定是原图还是压缩图，默认二者都有
					sourceType: ['camera'], //从相册选择
					success: function(res) {
						console.log(JSON.stringify(res.tempFiles));
						uni.uploadFile({
							url: "https://hryreadingroom.cn/garbage/upload/picture",
							name: "file",
							filePath: res.tempFiles[0].tempFilePath,
							success: (res) => {
								uni.navigateTo({
									url: '/pages/result/index?value=' + res.data
								})
							}
						})
					}
				});
			}
		}
	}
</script>

<style scoped lang="scss">
	.content {
		background-image: url("https://shop.julywhj.cn/2023/garbage/homebg.png");
		background-size: cover;
		min-height: 100vh;
		height: auto;
		background-color: #F8F9FA;
	}

	.status_bar {
		width: 100%;
	}

	.title {
		padding: 3rpx 50rpx;
		padding-bottom: 8rpx;
		display: flex;
		flex-direction: row;
		justify-content: center;
		align-items: center;
		color: #FFF;
	}

	.subTitle {
		text-align: center;
		font-size: 28rpx;
		color: #FFF;
		background-color: rgba(0, 0, 0, 0.3);
		padding: 20rpx;
		margin-left: 54rpx;
		margin-right: 54rpx;
		border-radius: 40rpx;
		margin-top: 60rpx;
	}

	.category {
		width: 330rpx;
		height: 330rpx;
	}

	.c1 {
		background-image: url("https://shop.julywhj.cn/2023/garbage/c1.png");
		background-size: cover;
	}

	.c2 {
		background-image: url("https://shop.julywhj.cn/2023/garbage/c2.png");
		background-size: cover;
	}

	.c3 {
		background-image: url("https://shop.julywhj.cn/2023/garbage/c3.png");
		background-size: cover;
	}

	.c4 {
		background-image: url("https://shop.julywhj.cn/2023/garbage/c4.png");
		background-size: cover;
	}

	.saoma {
		background-image: url("https://shop.julywhj.cn/2023/garbage/saoma.png");
		background-size: cover;
	}

	.wenzi {
		background-image: url("https://shop.julywhj.cn/2023/garbage/text.png");
		background-size: cover;
	}

	.c_test {
		background-image: url("");
		background-size: cover;
	}
</style>
