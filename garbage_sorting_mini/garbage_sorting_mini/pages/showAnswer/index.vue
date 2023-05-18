<template>
	<view class="content">
		<view class="flex justify-center pt-4">
			<view style="font-size: 48rpx; font-weight: bold;">题目答案</view>
		</view>

		<view v-for="item in examContents" :key="item.id">
			<view class="flex justify-center mt-4">
				<view class="flex">
					<view>第</view>
					<view class="ml-2" style="color: #05A975;">{{item.examOrder}}</view>
					<view class="ml-2">题</view>
				</view>
			</view>
			<view class="flex justify-center mt-1">

				<view v-if="item.successAnswer == item.chooseAnswer" class="success">
					<view class="flex justify-center">
						<view style="font-size: 48rpx; font-weight: bold;" class="mt-4">{{item.name}}</view>
					</view>
					<view class="flex justify-center">
						<view style="font-size: 36rpx;" class="mt-2">属于以下哪种类型的垃圾？</view>
					</view>
					<view class="flex justify-center mt-3">
						<view class="flex justify-between">
							<view class="text-center">
								<view class="result" :class="item.chooseAnswer"></view>
							</view>
						</view>
					</view>
				</view>

				<view v-else class="error">
					<view class="flex justify-center">
						<view style="font-size: 48rpx; font-weight: bold;" class="mt-4">{{item.name}}</view>
					</view>
					<view class="flex justify-center">
						<view style="font-size: 36rpx;" class="mt-2">属于以下哪种类型的垃圾？</view>
					</view>

					<view class="flex justify-center">
						<view class="flex justify-between">
							<view class="text-center">
								<view class="result" :class="item.chooseAnswer"></view>
								<view style="margin-top: -10rpx;font-size: 32rpx;">你选择的答案</view>
							</view>
							<view class="text-center">
								<view class="result" :class="item.successAnswer"></view>
								<view style="margin-top: -10rpx; font-size: 32rpx; font-weight: bold;">正确答案</view>
							</view>
						</view>
					</view>
				</view>
			</view>
		</view>


	</view>
</template>

<script>
	import request from '@/common/request.js';
	import cookie from "@/common/cookie.js";
	export default {
		onLoad(option) {
			if (option.examId == undefined || option.examId == '') {
				this.examId = 5;
			} else {
				this.examId = option.examId;
			}
			this.showExamContent();
		},
		data() {
			return {
				examId: 5,
				examContents: [],
			}
		},
		methods: {
			showExamContent() {
				request.get('/exam/showExamContent', {
					examId: this.examId,
				}, {
					login: false
				}).then(res => {
					this.examContents = res.data.data.examContents;
				});
			}
		}
	}
</script>

<style lang="scss">
	.content {
		min-height: 100vh;
		background-color: #FFF;
		background-size: 100% 100%;
	}

	.success {
		width: 646rpx;
		height: 340rpx;
		background-color: #D8FFFA;
		border-radius: 20rpx;
		border: #000 solid 5px;
		box-shadow: 0rpx 0rpx 20px #D8FFFA;
	}

	.error {
		width: 646rpx;
		height: 340rpx;
		background-color: #FFD8D8;
		border-radius: 20rpx;
		border: #000 solid 5px;
		box-shadow: 0rpx 0rpx 20px #FFD8D8;
	}

	.result {
		width: 280rpx;
		height: 120rpx;
	}

	.D {
		background-image: url('https://shop.julywhj.cn/2023/garbage/show_D.png');
		background-size: 100% 100%;
	}

	.A {
		background-image: url('https://shop.julywhj.cn/2023/garbage/show_A.png');
		background-size: cover;
	}

	.B {
		background-image: url('https://shop.julywhj.cn/2023/garbage/show_B.png');
		background-size: cover;
	}

	.C {
		background-image: url('https://shop.julywhj.cn/2023/garbage/show_C.png');
		background-size: cover;
	}
</style>
