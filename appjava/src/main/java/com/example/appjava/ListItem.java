package com.example.appjava;

import android.graphics.Bitmap;

public class ListItem {

    private Bitmap mThumbnail = null;


    private String mTitle = null;

    /**
     * 空のコンストラクタ
     */
    public ListItem() {

    }

    /**
     * コンストラクタ
     *
     * @param thumbnail サムネイル画像
     * @param title     タイトル
     */
    public ListItem(Bitmap thumbnail, String title) {
        mThumbnail = thumbnail;
        mTitle = title;
    }

    /**
     * サムネイル画像を取得
     *
     * @return サムネイル画像
     */
    public Bitmap getThumbnail() {
        return mThumbnail;
    }

    /**
     * サムネイル画像設定
     *
     * @param thumbnail サムネイル画像
     */
    public void setThumbnail(Bitmap thumbnail) {
        mThumbnail = thumbnail;
    }

    /**
     * タイトルを取得
     *
     * @return タイトル
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * タイトルを設定
     *
     * @param title タイトル
     */
    public void setTitle(String title) {
        this.mTitle = title;
    }


}
