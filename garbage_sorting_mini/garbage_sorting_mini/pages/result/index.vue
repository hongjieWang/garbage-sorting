<template>
	<view class="content">
		<view class="title" style="width: 646rpx; height: 447rpx; margin-left: 52rpx; margin-top: 80rpx; ">
			<view class="flex justify-center">
				<view style="margin-top: 84rpx; font-size: 72rpx; font-weight: bold;">
					{{categoryList[index].garbageName}}
				</view>
			</view>
			<view class="flex justify-center">
				<view style="border: 4rpx #000 solid; width: 518rpx; height: 0rpx; margin-top: 66rpx;"></view>
			</view>
			<view class="flex justify-center">
				<view style="margin-top: 48rpx; letter-spacing: 6rpx">属于垃圾分类的</view>
			</view>
		</view>

		<!--分类-->
		<view style="width: 100%;" class="flex justify-center">
			<view style="width: 646rpx; height: 290rpx; margin-top: 20rpx; background-size: 100% 100%;"
				:style="{'background-image':'url('+categoryList[index].garbageCategory.bgItem+')'}">
				<view class="flex">
					<view class=" ml-6" style="margin-top: 70rpx;">
						<image :src="categoryList[index].garbageCategory.bgIcon" style="width: 142rpx; height: 142rpx;">
						</image>
					</view>
					<view style="margin-top: 70rpx; margin-left: 10rpx;">
						<view style="color: #FFF; font-size: 36rpx; font-weight: bold;">
							{{categoryList[index].garbageCategory.categoryName}}
						</view>
						<view style="color: #FFF; font-size: 26rpx; width: 380rpx;">
							{{categoryList[index].garbageCategory.categoryExplain}}
						</view>
					</view>
				</view>
			</view>
		</view>

		<view style="width: 100%; color: #006FE5; font-size: 24rpx;" class="flex justify-center">
			点击卡片可查看还有哪些物品为可回收垃圾
		</view>

		<view style="width: 100%; color: #006FE5; font-size: 24rpx;" class="flex justify-center mt-2">

			<view v-if="index>0">
				<button style="height: 60rpx; line-height: 60rpx; background-color: #000; color: #FFF;" @click="last">上一个</button>
			</view>

			<view v-if="showNext" class="ml-4">
				<button style="height: 60rpx; line-height: 60rpx; background-color: #000; color: #FFF;" @click="next">下一个</button>
			</view>
		</view>

		<!--按钮-->
		<view class="flex" style="margin-left: 52rpx; margin-top: 84rpx;">
			<view class="flex justify-center align-center"
				style="width: 172rpx; height: 172rpx; background-color: #000; border-radius: 86rpx;">
				<image src="https://shop.julywhj.cn/2023/garbage/saoma_icon.png" style="width: 60rpx; height: 60rpx;">
				</image>
			</view>
			<view class="flex align-center" @click="onclickReSeach()"
				style="justify-content: space-evenly; margin-left:40rpx; width: 434rpx; height: 172rpx; background-color: #000; border-radius: 86rpx;">
				<view>
					<image src="https://shop.julywhj.cn/2023/garbage/res_seach.png"
						style="width: 65rpx; height: 70rpx; "></image>
				</view>
				<view style="color: #FFF;">再次搜索</view>
			</view>
		</view>
	</view>
</template>

<script>
	import request from '@/common/request.js';

	export default {
		onLoad(option) {
			if (option.value == undefined || option.value == '') {
				this.value = "小龙虾";
			} else {
				this.value = option.value;
			}
			this.queryByGarbage(this.value);
		},
		data() {
			return {
				value: "",
				categoryList: [],
				size: 0,
				index: 0,
				showNext: true,
				categoryInfo: {
					bgItem: "https://shop.julywhj.cn/2023/garbage/kehuishoubg1.png",
					bgIcon: "https://shop.julywhj.cn/2023/garbage/kehuishouicon.png",
					categoryName: "可回收垃圾",
					categoryExplain: "废纸张、废塑料、废玻璃制品、废金属、废织物等适宜回收、可循环利用的生活废弃物"
				}
			}
		},
		methods: {

			onclickReSeach() {
				uni.navigateTo({
					url: '/pages/seach/index'
				})
			},
			queryByGarbage(value) {
				request.get('/garbage/queryLike', {
					name: value
				}, {
					login: false
				}).then(res => {
					this.categoryList = res.data.data;
					this.size = res.data.data.length;
				});
			},
			next() {
				this.index = this.index + 1;
				this.showNext = this.index < this.size - 1;
			},
			last() {
				this.index = this.index - 1;
				this.showNext = this.index < this.size - 1;
			}
		}
	}
</script>

<style lang="scss">
	.title {
		background-image: url("https://shop.julywhj.cn/2023/garbage/restu_bg.png");
		background-size: 100% 100%;

	}
</style>
