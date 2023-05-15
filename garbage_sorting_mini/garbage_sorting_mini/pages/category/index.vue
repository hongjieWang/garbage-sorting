<template>
	<view class="content" :style="{'background-image':'url('+categoryInfo.imageUrl+')'}">
		<!--top-->
		<view style="width: 100%;" class="flex justify-center">
			<view style="width: 646rpx; height: 290rpx; margin-top: 20rpx; background-size: 100% 100%;"
				:style="{'background-image':'url('+categoryInfo.bgItem+')'}">
				<view class="flex">
					<view class=" ml-6" style="margin-top: 70rpx;">
						<image :src="categoryInfo.bgIcon" style="width: 142rpx; height: 142rpx;"></image>
					</view>
					<view style="margin-top: 70rpx; margin-left: 10rpx;">
						<view style="color: #FFF; font-size: 36rpx; font-weight: bold;">{{categoryInfo.categoryName}}
						</view>
						<view style="color: #FFF; font-size: 26rpx; width: 380rpx;">{{categoryInfo.categoryExplain}}
						</view>
					</view>
				</view>
			</view>
		</view>

		<!--content-->
		<view style="margin-left: 130rpx; margin-right: 130rpx; margin-top: 60rpx;">
			<view style="font-size: 48rpx; font-weight: bold " :style="{'color':categoryInfo.color}">处理方式</view>
			<view style="margin-top: 20rpx; font-size: 36rpx;" :style="{'color':categoryInfo.color}">
				{{categoryInfo.categoryRequire}}
			</view>
			<view style="margin-top: 20rpx;  font-size: 36rpx; font-weight: bold; "
				:style="{'color':categoryInfo.color}">
				实物举例</view>
			<view style="margin-top: 20rpx;  font-size: 36rpx;" :style="{'color':categoryInfo.color}">
				{{categoryInfo.categoryCommon}}
			</view>
		</view>
	</view>
</template>

<script>
	import request from '@/common/request.js';
	export default {
		onLoad(option) {
			if (option.categoryNo == undefined || option.categoryNo == '') {
				this.categoryNo = "A";
			} else {
				this.categoryNo = option.categoryNo;
			}
			this.queryByCategoryNo(this.categoryNo);
		},
		data() {
			return {
				categoryNo: "",
				categoryInfo:{},
			};
		},
		methods: {
			queryByCategoryNo(categoryNo) {
				request.get('/garbageCategory/queryByCategoryNo', {
					categoryNo: categoryNo
				}, {
					login: false
				}).then(res => {
					this.categoryInfo = res.data.data;
					console.log(this.categoryInfo)
				});
			},
		}
	}
</script>

<style lang="scss">
	.content {
		background-size: 100% 100%;
		min-height: 100vh;
		background-color: #F8F9FA;
		// font-family: OPPOSans;
	}

	@font-face {
		font-family: 'OPPOSans';
	}
</style>
