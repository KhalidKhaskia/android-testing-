package com.example.saeedazem.scroll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import android.widget.ViewFlipper;


public class MainActivity extends Activity  {
    FlyOutContainer root;
    private Adapter dp;
    private Adapterr dpr;
    private AdapterAc ada;
    private AdapterCo adCo;
    private Adapterfa adFa;
    private GridView ls;
    String ss;

    public static final String CATEGORY = "all";
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    private ViewFlipper mViewFlipper;
    private AnimationListener mAnimationListener;
    private Context mContext;

    public void toggleMenu(View v){
        this.root.toggleMenu();
    }



    @SuppressWarnings("deprecation")
    private final GestureDetector detector = new GestureDetector(new SwipeGestureDetector());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.root = (FlyOutContainer) this.getLayoutInflater().inflate(R.layout.activity_main, null);
        this.setContentView(root);///////////////////////////////////////////
        mContext = this;
        mViewFlipper = (ViewFlipper) this.findViewById(R.id.view_flipper);
        mViewFlipper.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(final View view, final MotionEvent event) {
                detector.onTouchEvent(event);
                return true;
            }
        });


        findViewById(R.id.play).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //sets auto flipping
                mViewFlipper.setAutoStart(true);
                mViewFlipper.setFlipInterval(4000);
                mViewFlipper.startFlipping();
            }
        });

        findViewById(R.id.stop).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //stop auto flipping
                mViewFlipper.stopFlipping();
            }
        });


        //animation listener
        mAnimationListener = new Animation.AnimationListener() {
            public void onAnimationStart(Animation animation) {
                //animation started event
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationEnd(Animation animation) {
                //TODO animation stopped event
            }
        };
        adCo=new AdapterCo(getApplicationContext());
        adFa=new Adapterfa(getApplicationContext());
        ada=new AdapterAc(getApplicationContext());
        dp = new Adapter(getApplicationContext());
        dpr=new Adapterr(getApplicationContext());
        ls = (GridView) findViewById(R.id.gridView);
        ls.setAdapter(dp);
    }


    class SwipeGestureDetector extends SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            try {
                // right to left swipe
                if (e1.getX() - e2.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_in));
                    mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext, R.anim.left_out));
                    // controlling animation
                    mViewFlipper.getInAnimation().setAnimationListener(mAnimationListener);
                    mViewFlipper.showNext();
                    return true;
                } else if (e2.getX() - e1.getX() > SWIPE_MIN_DISTANCE && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY) {
                    mViewFlipper.setInAnimation(AnimationUtils.loadAnimation(mContext, R.anim.right_in));
                    mViewFlipper.setOutAnimation(AnimationUtils.loadAnimation(mContext,R.anim.right_out));
                    // controlling animation
                    mViewFlipper.getInAnimation().setAnimationListener(mAnimationListener);
                    mViewFlipper.showPrevious();
                    return true;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void category(View v) {
        //ls= (GridView) findViewById(R.id.gridView);
        switch (v.getId()) {
            case R.id.action:
                ls.setAdapter(ada);
                ls.invalidateViews();
                ss = "action";
                break;

            case R.id.drama:
                ls.setAdapter(dpr);
                ls.invalidateViews();
                ss = "drama";
                break;

            case R.id.family:
                ls.setAdapter(adFa);
                ls.invalidateViews();
                ss = "family";
                break;

            case R.id.comedy:
                ls.setAdapter(adCo);
                ls.invalidateViews();
                ss = "comedy";
                break;

            default:
                ls.setAdapter(dp);
                ls.invalidateViews();
                ss = "all";
                break;


        }
        Toast.makeText(this, "The chois is " + ss, Toast.LENGTH_LONG).show();
//        Intent swap=new Intent(this, Adapter.class);
//        swap.putExtra(CATEGORY,ss);
//        startActivity(swap);

    }



}
