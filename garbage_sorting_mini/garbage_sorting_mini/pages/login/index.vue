<template>
	<view>
		<button class="avatar-wrapper" open-type="chooseAvatar" @chooseavatar="onChooseAvatar">
			<image class="avatar" :src="avatarUrl"></image>
		</button>
		<input type="nickname" class="weui-input" placeholder="请输入昵称" />
	</view>
</template>

<script>
	export default {
		data() {
			return {
				avatarUrl: "https://mmbiz.qpic.cn/mmbiz/icTdbqWNOwNRna42FI242Lcia07jQodd2FJGIYQfG0LAJGFxM4FbnQP6yfMxBgJ0F3YRqJCJ1aPAK2dQagdusBZg/0",
			}
		},
		methods: {
			onChooseAvatar(e) {
				this.avatarUrl = e.detail.avatarUrl
			}
		},
	}
</script>

<style>
	view {
		display: block;
	}

	.avatar {
		display: block;
		width: 56px;
		height: 56px;
	}

	button {
		border-radius: 4px;
		font-size: 17px;
		font-weight: 700;
		line-height: 1.41176471;
		padding: 8px 24px;
	}

	.weui-input {
		width: 100%;
		border: 0;
		outline: 0;
		-webkit-appearance: none;
		background-color: transparent;
		font-size: inherit;
		color: inherit;
		height: 1.41176471em;
		line-height: 1.41176471;
	}
</style>
