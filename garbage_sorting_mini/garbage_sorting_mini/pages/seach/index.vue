<template>
	<view class="content">
		<!--名称-->
		<view class="flex justify-center">
			<view class="input">
				<input v-model="garbage" style="width: 100%;" confirm-type="search" focus placeholder="在这里输入你要查询的物品" />
			</view>
		</view>

		<!--历史搜索-->
		<view class="mt-4 row ml-6 mr-6" style="height: 0rpx;">
			<view v-for="(item,j) in historySeach" :key="j">
				<view @click="seachHistory(item)" class="tagLabel">{{item}}</view>
			</view>
		</view>

		<!--按钮-->
		<view class="flex justify-center">
			<button class="buttonStyle" style="margin-top: 354rpx;" @click="seach">开始查询</button>
		</view>

	</view>
</template>

<script>
	import request from '@/common/request.js';
	import cookie from "@/common/cookie.js";
	export default {
		onLoad() {
			var arr = cookie.get("historySeach");
			if (arr instanceof Array) {
				this.historySeach = arr;
			}
		},
		data() {
			return {
				garbage: "",
				historySeach: ["瓶子", "塑料包装袋"]
			}
		},
		methods: {
			addHistorySeach(value) {
				console.log(this.historySeach);
				this.historySeach.unshift(value);
				if (this.historySeach.length > 6) {
					this.historySeach.pop();
				}
				cookie.set("historySeach", this.historySeach, 1000)
			},
			seach() {
				console.log(this.garbage);
				this.addHistorySeach(this.garbage);
				uni.navigateTo({
					url: '/pages/result/index?value=' + this.garbage
				})
			},
			seachHistory(garbage) {
				uni.navigateTo({
					url: '/pages/result/index?value=' + garbage
				})
			}
		}
	}
</script>

<style lang="scss">
	.content {
		background-image: url("https://shop.julywhj.cn/2023/garbage/seach_bg.png");
		min-height: 100vh;
		background-color: #F8F9FA;
		background-size: 100% 100%;
	}

	.input {
		display: flex;
		justify-content: center;
		text-align: center;
		align-items: center;
		background-color: #EEEEEE;
		width: 640rpx;
		height: 140rpx;
		margin-top: 430rpx;
		border-radius: 70rpx;
		border: 6rpx solid #000
	}

	.buttonStyle {
		background-color: #000;
		width: 434rpx;
		height: 140rpx;
		border-radius: 70rpx;
		color: #FFF;
		line-height: 140rpx
	}

	.tagLabel {
		background-color: #DEDEDE;
		padding-top: 6rpx;
		padding-bottom: 6rpx;
		padding-left: 30rpx;
		padding-right: 30rpx;
		margin: 10rpx;
		border-radius: 30rpx;
		font-size: 28rpx;
	}
</style>
