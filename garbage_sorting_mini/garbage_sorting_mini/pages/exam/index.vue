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
		<view class="buttonExam" @click="createExam">
			开始测试
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
		data() {
			return {
				// 状态栏高度
				navBarTop: 0,
				// 导航栏高度
				navBarHeight: 0,
				openId: "123"
			}
		},
		methods: {
			createExam() {
				uni.navigateTo({
					url: '/pages/questions/index'
				})
			},
			backHome() {
				uni.reLaunch({
					url: '/pages/home/index'
				})
			}
		}
	}
</script>

<style lang="scss">
	.content {
		background-image: url('https://shop.julywhj.cn/2023/garbage/exam_bg.png');
		background-size: cover;
		min-height: 100vh;
		height: auto;
		background-color: #F8F9FA;
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

	.buttonExam {
		background-color: #000;
		color: #FFF;
		width: 434rpx;
		height: 172rpx;
		border-radius: 82rpx;
		display: flex;
		justify-content: center;
		align-items: center;
		margin-top: 780rpx;
		margin-left: 158rpx;
		font-size: 36rpx;
	}
</style>
