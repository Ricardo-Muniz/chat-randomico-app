package br.com.nouva.randomchat.Helper;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Interpolator;

import androidx.viewpager.widget.ViewPager;

import java.lang.reflect.Field;

public class FixedSpeedScroller extends ViewPager {

    public FixedSpeedScroller(Context context) {
        super(context);
        postInitViewPager();
    }

    public FixedSpeedScroller(Context context, AttributeSet attrs) {
        super(context, attrs);
        postInitViewPager();
    }

    private ScrollerCustomDuration mScroller = null;

    /**
     * Override the Scroller instance with our own class so we can change the
     * duration
     */
    private void postInitViewPager() {
        try {
            Field scroller = ViewPager.class.getDeclaredField("mScroller");
            scroller.setAccessible(true);
            Field interpolator = ViewPager.class.getDeclaredField("sInterpolator");
            interpolator.setAccessible(true);

            mScroller = new ScrollerCustomDuration(getContext(),
                    (Interpolator) interpolator.get(null));
            scroller.set(this, mScroller);
        } catch (Exception e) {
        }
    }

    /**
     * Set the factor by which the duration will change
     */
    public void setScrollDurationFactor(double scrollFactor) {
        mScroller.setScrollDurationFactor(scrollFactor);
    }

}