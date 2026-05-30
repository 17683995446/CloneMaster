# 🎉 GitHub 托管 - 一分钟上手

## 方式一: 使用脚本自动初始化 (最快)

```bash
cd /workspace
./init_github.sh
```

跟着提示操作，脚本会帮您完成所有Git配置！

---

## 方式二: 手动操作

### 步骤 1: 初始化Git仓库

```bash
cd /workspace

# 初始化Git仓库
git init
git branch -M main

# 添加所有文件
git add .

# 提交
git commit -m "Initial commit: CloneMaster Android App Cloner"
```

### 步骤 2: 在 GitHub 上创建仓库

1. 访问 https://github.com/new
2. 仓库名称输入: `CloneMaster`
3. 保持默认设置，点击 **Create repository**

### 步骤 3: 推送代码到 GitHub

```bash
# 替换下面的 您的用户名 为真实的GitHub用户名
git remote add origin https://github.com/您的用户名/CloneMaster.git
git push -u origin main
```

### 步骤 4: 获取APK (自动构建)

1. 刷新您的 GitHub 仓库页面
2. 点击 **Actions** 标签页
3. 等待工作流运行完成 (约2-5分钟)
4. 完成后，点击最新的工作流
5. 向下滚动到 **Artifacts** 部分
6. 下载 `debug-apk` 或 `release-apk`

---

## 📂 已准备好的GitHub文件

| 文件 | 说明 |
|------|------|
| [.github/workflows/build.yml](.github/workflows/build.yml) | GitHub Actions 自动构建 |
| [.gitignore](.gitignore) | Git忽略文件配置 |
| [README.md](README.md) | 项目说明 |
| [GITHUB_GUIDE.md](GITHUB_GUIDE.md) | GitHub 详细指南 |
| [init_github.sh](init_github.sh) | 一键初始化脚本 |

---

## ✨ GitHub Actions 特点

✅ **自动构建** - 每次提交代码自动构建  
✅ **双版本** - Debug + Release 两个APK  
✅ **90天保存** - 构建产物保存90天  
✅ **无需本地环境** - 完全云端构建  

---

## 📱 构建好的APK

构建完成后，在 GitHub Actions 中下载:
- **Debug APK**: `app-debug.apk`
- **Release APK**: `app-release.apk`

---

## 🚀 现在就开始吧！

最简单的方式: 直接运行 `./init_github.sh`！
