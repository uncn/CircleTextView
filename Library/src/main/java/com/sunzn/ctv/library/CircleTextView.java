package com.sunzn.ctv.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;

import androidx.annotation.ColorInt;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created by sunzn on 2017/6/9.
 */

public class CircleTextView extends AppCompatTextView {

    private int mCircleColor = Color.parseColor("#ED1C24");
    private int mBorderColor = Color.parseColor("#2DB354");
    private int mShadowColor = Color.parseColor("#FF9632");

    private float mBorderWidth;
    private float mShadowWidth;
    private float mCircleAlpha;
    private float mBorderAlpha;

    private float mCircleRadius;
    private Paint mPaint;

    public CircleTextView(Context context) {
        this(context, null);
    }

    public CircleTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        TypedArray attributes = context.obtainStyledAttributes(attrs, R.styleable.CircleTextView, defStyleAttr, 0);

        mCircleColor = attributes.getColor(R.styleable.CircleTextView_ctv_circleColor, mCircleColor);
        mBorderColor = attributes.getColor(R.styleable.CircleTextView_ctv_borderColor, mBorderColor);
        mShadowColor = attributes.getColor(R.styleable.CircleTextView_ctv_shadowColor, mShadowColor);

        mBorderWidth = attributes.getFloat(R.styleable.CircleTextView_ctv_borderWidth, 0);
        mShadowWidth = attributes.getFloat(R.styleable.CircleTextView_ctv_shadowWidth, 0);
        mCircleAlpha = attributes.getFloat(R.styleable.CircleTextView_ctv_circleAlpha, 1);
        mBorderAlpha = attributes.getFloat(R.styleable.CircleTextView_ctv_borderAlpha, 1);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        attributes.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int size = Math.min(width, height);
        setMeasuredDimension(size, size);
        mCircleRadius = size >> 1;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mShadowWidth != 0) {
            setBackgroundCompat(getMeasuredWidth(), getMeasuredHeight());
        }

        if (mBorderWidth != 0) {
            mPaint.setColor(mBorderColor);
            mPaint.setStyle(Paint.Style.FILL);
            mPaint.setAlpha((int) (255 * mBorderAlpha));
            canvas.drawCircle(mCircleRadius, mCircleRadius, mCircleRadius - mShadowWidth, mPaint);
        }

        mPaint.setColor(Color.WHITE);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(mCircleRadius, mCircleRadius, mCircleRadius - mShadowWidth - mBorderWidth, mPaint);

        mPaint.setColor(mCircleColor);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAlpha((int) (255 * mCircleAlpha));
        canvas.drawCircle(mCircleRadius, mCircleRadius, mCircleRadius - mShadowWidth - mBorderWidth, mPaint);

        super.onDraw(canvas);
    }

    public void setColor(@ColorInt int color) {
        mCircleColor = color;
        mBorderColor = color;
        mShadowColor = color;
        invalidate();
    }

    private void setBackgroundCompat(int w, int h) {
        Bitmap bitmap = createShadowBitmap(w, h, 360, mShadowWidth, mShadowColor);
        BitmapDrawable drawable = new BitmapDrawable(getResources(), bitmap);
        setBackground(drawable);
    }

    private Bitmap createShadowBitmap(int shadowWidth, int shadowHeight, float cornerRadius, float shadowRadius, int shadowColor) {
        Bitmap output = Bitmap.createBitmap(shadowWidth, shadowHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        RectF shadowRect = new RectF(shadowRadius, shadowRadius, shadowWidth - shadowRadius, shadowHeight - shadowRadius);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);

        if (!isInEditMode()) {
            paint.setShadowLayer(shadowRadius, 0, 0, shadowColor);
        }

        canvas.drawRoundRect(shadowRect, cornerRadius, cornerRadius, paint);

        return output;
    }

}
