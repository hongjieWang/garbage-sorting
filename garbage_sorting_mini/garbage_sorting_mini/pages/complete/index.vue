<template>
	<view class="content">
		<view class="title" :style="{paddingTop:navBarTop+'px',height:navBarHeight+'px',lineHeight:navBarHeight+'px'}">
			<view class="flex align-center justify-between" style="width: 100%;">
				<view @click="backHome" class="flex align-center ">
					<image style="width: 50rpx; height: 50rpx;"
						src="https://shop.julywhj.cn/2023/garbage/home_icon.png"></image>
				</view>
				<view style="margin-left: -50rpx;">垃圾分类鉴别</view>
				<view></view>
			</view>
		</view>
		<!-- <uni-nav-bar title="导航栏组件"></uni-nav-bar> -->

		<view class="flex justify-center" style="margin-top: 400rpx;">
			<view class="flex align-center">
				<view style="font-size: 72rpx; color: #FFFFFF;">我答对了</view>
				<view style="font-size: 120rpx; color: #F6C167; font-weight: bold; margin-left: 20rpx;">{{exam.correct}}
				</view>
				<view style="font-size: 72rpx; color: #FFFFFF;margin-left: 20rpx;">道题</view>
			</view>
		</view>

		<view class="flex justify-center" style="margin-top: 100rpx;">
			<view @click="showAnswer" style="font-size: 36rpx; font-weight: bold; color: #F6C167;">查看答案</view>
		</view>

		<view class="flex justify-center" style="margin-top: 144rpx;">
			<view class="again" @click="handelAgain">再来一次</view>
		</view>
		<view class="flex justify-center" style="margin-top: 40rpx;">
			<button class="shareBtn" open-type="share">分享</button>
		</view>
	</view>
</template>

<script>
	import request from '@/common/request.js';
	import cookie from "@/common/cookie.js";

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
		onLoad(option) {
			uni.showShareMenu({
				withShareTicket: true,
				menus: ["shareAppMessage", "shareTimeline"]
			});
			if (option.examId == undefined || option.examId == '') {
				this.examId = 5;
			} else {
				this.examId = option.examId;
			};
			this.showExam();
		},
		//分享到聊天
		onShareAppMessage(res) {
			return {
				title: '我答对了 ' + this.exam.correct + ' 道题 , 快来试试你能答对几道题吧！',
				path: 'pages/home/index' //界面路径
			}
		},
		//分享到朋友圈
		onShareTimeline: function() {
			return {
				title: '我答对了 ' + this.exam.correct + ' 道题 , 快来试试你能答对几道题吧！',
				imageUrl: 'https://shop.julywhj.cn/2023/garbage/shareQr.jpg'
			}
		},
		data() {
			return {
				// 状态栏高度
				navBarTop: 0,
				// 导航栏高度
				navBarHeight: 0,
				examId: 4,
				exam: {},
			}
		},
		methods: {
			showExam() {
				request.get('/exam/showExamContent', {
					examId: this.examId,
				}, {
					login: false
				}).then(res => {
					this.exam = res.data.data;
					this.examId = res.data.data.id;
				});
			},
			showAnswer() {
				uni.navigateTo({
					url: '/pages/showAnswer/index?examId=' + this.examId
				})
			},
			backHome() {
				uni.reLaunch({
					url: '/pages/home/index'
				})
			},
			handelAgain() {
				uni.navigateTo({
					url: '/pages/exam/index'
				})
			},
		}
	}
</script>

<style lang="scss">
	.content {
		background-image: url('https://shop.julywhj.cn/2023/garbage/complete_bg.png');
		background-size: cover;
		min-height: 100vh;
		height: auto;
		background-color: #F8F9FA;
	}

	.canvas {
		position: fixed;
		left: -999999rpx;
		top: -999999rpx;
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

	.again {
		font-size: 36rpx;
		color: #FFF;
		background-color: #000;
		width: 434rpx;
		height: 138rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		border-radius: 69rpx;
	}

	.shareBtn {
		font-size: 36rpx;
		color: #FFF;
		background-color: #000;
		width: 434rpx;
		height: 172rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		border-radius: 86rpx;
	}
</style>
