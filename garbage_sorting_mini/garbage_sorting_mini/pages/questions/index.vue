<template>
	<view class="content">
		<view class="flex justify-center align-end" style="padding-top: 74rpx;">
			<view style="font-size: 36rpx;" class="flex">
				<view>第</view>
				<view class="ml-1" style="color: #05A975;">{{atPresent + 1}}</view>
				<view class="ml-1">题</view>
			</view>
			<view class="ml-2" style="font-size: 28rpx;">共{{total}}题</view>
		</view>

		<view class="flex justify-center">
			<view class="questions">
				<view style="font-size: 48rpx; font-weight: bold; margin-top: 140rpx;">{{examContent.name}}</view>
				<view style="margin-top: 116rpx;">属于以下哪种类型的垃圾？</view>
			</view>
		</view>

		<view class="flex justify-end mt-5">
			<view class="flex mr-5">
				<button @click="lastQuestion" v-show="lastClick" class="btn">上一题</button>
				<button @click="nextQuestion" v-show="nextClick" class="btn ml-2">下一题</button>
			</view>
		</view>

		<view class="flex justify-center" style="margin-top: 86rpx;">
			<view style="font-size: 48rpx; font-weight: bold;">选 项</view>
		</view>

		<view class="flex justify-center" style="margin-top: 36rpx;">
			<view>
				<view class="questionBtn D "
					:class="[examContent.chooseAnswer == 'D' ? 'border' : examContent.chooseAnswer == null ? '':'mask']"
					@click="questionHander('D')"></view>
				<view class="questionBtn B "
					:class="[examContent.chooseAnswer == 'B' ? 'border' : examContent.chooseAnswer == null ? '':'mask']"
					@click="questionHander('B')">
				</view>
			</view>
			<view>
				<view class="questionBtn C "
					:class="[examContent.chooseAnswer == 'C' ? 'border' : examContent.chooseAnswer == null ? '':'mask']"
					@click="questionHander('C')">
				</view>
				<view class="questionBtn A "
					:class="[examContent.chooseAnswer == 'A' ? 'border' : examContent.chooseAnswer == null ? '':'mask']"
					@click="questionHander('A')">
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import request from '@/common/request.js';
	import cookie from "@/common/cookie.js";
	export default {
		onShow() {
			this.openId = cookie.get("openId");
			this.createExam();
		},
		data() {
			return {
				openId: "",
				total: 10,
				atPresent: 1,
				nextClick: true,
				lastClick: false,
				name: "老鼠药",
				answer: "",
				examContents: [],
				examContent: {}
			}
		},
		methods: {
			createExam() {
				request.get('/exam/createExam', {
					openId: this.openId,
				}, {
					login: false
				}).then(res => {
					this.examContents = res.data.data.examContents;
					this.examContent = res.data.data.examContents[res.data.data.atPresent];
					this.atPresent = res.data.data.atPresent;
					this.total = res.data.data.total;
				});
			},
			questionHander(answer) {
				this.answer = answer;
				this.examContent.chooseAnswer = answer;
				request.get('/exam/answerQuestions', {
					examId: this.examContent.examId,
					order: this.examContent.examOrder,
					answer: answer,
				}, {
					login: false
				}).then(res => {
					//答题完成
					if (res.data.data.finish == 1) {
						uni.navigateTo({
							url: '/pages/complete/index?examId=' + this.examContent.examId
						})
					}
				});
			},
			nextQuestion() {
				this.atPresent = this.atPresent + 1;
				this.examContent = this.examContents[this.atPresent];
				this.lastClick = this.atPresent >= 1;
				this.nextClick = this.atPresent < this.total - 1;
			},
			lastQuestion() {
				this.atPresent = this.atPresent - 1;
				this.examContent = this.examContents[this.atPresent];
				this.lastClick = this.atPresent >= 1;
				this.nextClick = this.atPresent < this.total - 1;
			}
		}
	}
</script>

<style lang="scss">
	.content {
		min-height: 100vh;
		height: auto;
		background-color: #F8F9FA;
	}

	.questions {
		width: 646rpx;
		height: 508rpx;
		background-color: #D8FFFA;
		border-radius: 20rpx;
		border: 6rpx solid #000;
		margin-top: 86rpx;
		text-align: center;
	}

	.btn {
		background-color: #000;
		color: #FFF;
		padding-left: 40rpx;
		padding-right: 40rpx;
		border-radius: 40rpx;
		font-size: 24rpx;
	}

	.questionBtn {
		width: 312rpx;
		height: 160rpx;
		border-radius: 30rpx;
		border: #FFF solid 5px;
	}

	.D {
		background-image: url('https://shop.julywhj.cn/2023/garbage/question_D.png');
		background-size: cover;
	}

	.A {
		background-image: url('https://shop.julywhj.cn/2023/garbage/question_A.png');
		background-size: cover;
	}

	.B {
		background-image: url('https://shop.julywhj.cn/2023/garbage/question_B.png');
		background-size: cover;
	}

	.C {
		background-image: url('https://shop.julywhj.cn/2023/garbage/question_C.png');
		background-size: cover;
	}

	.mask {
		opacity: 0.5
	}

	.border {
		border: #000 solid 5px;
	}
</style>
