package com.example.hwalasdk;


import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.hwalasdk.R;

public class HwalaKeyboardChar extends LinearLayout implements View.OnClickListener,View.OnLongClickListener {

    // constructors
    public HwalaKeyboardChar(Context context) {
        this(context, null, 0);
    }

    public HwalaKeyboardChar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    boolean ISHwalaKeyboardChar;
    public HwalaKeyboardChar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.HwalaKeyboardChar, 0, 0);
        try {
            ISHwalaKeyboardChar = ta.getBoolean(R.styleable.HwalaKeyboardChar_ISHwalaKeyboardChar, false);
        } finally {

        }
    }
    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;
    private Button mButton0;
    private LinearLayout mButtonDelete_number,mButtonEnter_number;
    //    private Button mButtonplus_number;
    private Button mButtondash_number;
    private Button mButtondot_number;
    private Button mButtoncomma_number;
    // keyboard keys (buttons)
    private Button mButton_q;
    private Button mButton_w;
    private Button mButton_e;
    private Button mButton_r;
    private Button mButton_t;
    private Button mButton_y;
    private Button mButton_u;
    private Button mButton_i;
    private Button mButton_o;
    private Button mButton_p;
    private Button mButton_a;
    private Button mButton_s;
    private Button mButton_d;
    private Button mButton_f;
    private Button mButton_g;
    private Button mButton_h;
    private Button mButton_j;
    private Button mButton_k;
    private Button mButton_l;
    private Button mButton_z;
    private Button mButton_x;
    private Button mButton_c;
    private Button mButton_v;
    private Button mButton_b;
    private Button mButton_n;
    private Button mButton_m;
    private LinearLayout mButtonDelete,keychar,keynumber,keycharar,keycharen;
    private LinearLayout mButtonEnter;
    private Button mButtonspace;
    private Button mButtondash;
    private Button mButtondot,mButtonchange,mButtonchangechar;
//    private Button mButtoncomma;


    // This will map the button resource id to the String value that we want to
    // input when that button is clicked.
    SparseArray<String> keyValues = new SparseArray<>();

    // Our communication link to the EditText
    InputConnection inputConnection;
    Context mcontext;

    private void init(Context context, AttributeSet attrs) {
        mcontext=context;
        // initialize buttons
        LayoutInflater.from(context).inflate(R.layout.keyboardchar, this, true);
        keychar=  findViewById(R.id.keychar);
        keynumber=  findViewById(R.id.keynumber);
        keycharar=  findViewById(R.id.keychar_ar);
        keycharen=  findViewById(R.id.keychar_en);
        keycharen.setVisibility(View.GONE);
        keycharar.setVisibility(View.VISIBLE);

        mButton_q= (Button) findViewById(R.id.button_q);
        mButton_w= (Button) findViewById(R.id.button_w);
        mButton_e= (Button) findViewById(R.id.button_e);
        mButton_r= (Button) findViewById(R.id.button_r);
        mButton_t= (Button) findViewById(R.id.button_t);
        mButton_y= (Button) findViewById(R.id.button_y);
        mButton_u= (Button) findViewById(R.id.button_u);
        mButton_i= (Button) findViewById(R.id.button_i);
        mButton_o= (Button) findViewById(R.id.button_o);
        mButton_p= (Button) findViewById(R.id.button_p);
        mButton_a= (Button) findViewById(R.id.button_a);
        mButton_s= (Button) findViewById(R.id.button_s);
        mButton_d= (Button) findViewById(R.id.button_d);
        mButton_f= (Button) findViewById(R.id.button_f);
        mButton_g= (Button) findViewById(R.id.button_g);
        mButton_h= (Button) findViewById(R.id.button_h);
        mButton_j= (Button) findViewById(R.id.button_j);
        mButton_k= (Button) findViewById(R.id.button_k);
        mButton_l= (Button) findViewById(R.id.button_l);
        mButton_z= (Button) findViewById(R.id.button_z);
        mButton_x= (Button) findViewById(R.id.button_x);
        mButton_c= (Button) findViewById(R.id.button_c);
        mButton_v= (Button) findViewById(R.id.button_v);
        mButton_b= (Button) findViewById(R.id.button_b);
        mButton_n= (Button) findViewById(R.id.button_n);
        mButton_m= (Button) findViewById(R.id.button_m);
        //        -----------------------------------------------------------------
        mButtonDelete = (LinearLayout) findViewById(R.id.button_delete);
        mButtonEnter = (LinearLayout) findViewById(R.id.button_enter);
        mButtonspace = (Button) findViewById(R.id.button_space);
        mButtondash = (Button) findViewById(R.id.button_dash);
        mButtondot = (Button) findViewById(R.id.button_point);
        mButtonchange = findViewById(R.id.button_change);
        mButtonchangechar = findViewById(R.id.button_change_char);
//        -----------------------------------------------------------------
        mButton1 = (Button) findViewById(R.id.button_1);
        mButton2 = (Button) findViewById(R.id.button_2);
        mButton3 = (Button) findViewById(R.id.button_3);
        mButton4 = (Button) findViewById(R.id.button_4);
        mButton5 = (Button) findViewById(R.id.button_5);
        mButton6 = (Button) findViewById(R.id.button_6);
        mButton7 = (Button) findViewById(R.id.button_7);
        mButton8 = (Button) findViewById(R.id.button_8);
        mButton9 = (Button) findViewById(R.id.button_9);
        mButton0 = (Button) findViewById(R.id.button_0);
        mButtonDelete_number = (LinearLayout) findViewById(R.id.button_delete_number);
        mButtonEnter_number = (LinearLayout) findViewById(R.id.button_enter_number);
//        mButtonDisable = (Button) findViewById(R.id.button_disable);
//        mButtonplus_number = (Button) findViewById(R.id.button_plus_number);
        mButtondash_number = (Button) findViewById(R.id.button_dash_number);
        mButtondot_number = (Button) findViewById(R.id.button_point_number);
        mButtoncomma_number = (Button) findViewById(R.id.button_comma_number);
        //        -----------------------------------------------------------------
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);
        mButton0.setOnClickListener(this);
        mButtonDelete_number.setOnClickListener(this);
        mButtonEnter_number.setOnClickListener(this);
//        mButtonDisable.setOnClickListener(this);
//        mButtonplus.setOnClickListener(this);
        mButtondash_number.setOnClickListener(this);
        mButtondot_number.setOnClickListener(this);
        mButtoncomma_number.setOnClickListener(this);



//        -----------------------------------------------------------------
        // set button click listeners
        mButton_q.setOnClickListener(this);
        mButton_w.setOnClickListener(this);
        mButton_e.setOnClickListener(this);
        mButton_r.setOnClickListener(this) ;
        mButton_t.setOnClickListener(this) ;
        mButton_y.setOnClickListener(this) ;
        mButton_u.setOnClickListener(this);
        mButton_i.setOnClickListener(this);
        mButton_o.setOnClickListener(this);
        mButton_p.setOnClickListener(this);
        mButton_a.setOnClickListener(this);
        mButton_s.setOnClickListener(this);
        mButton_d.setOnClickListener(this);
        mButton_f.setOnClickListener(this);
        mButton_g.setOnClickListener(this);
        mButton_h.setOnClickListener(this);
        mButton_j.setOnClickListener(this);
        mButton_k.setOnClickListener(this);
        mButton_l.setOnClickListener(this);
        mButton_z.setOnClickListener(this);
        mButton_x.setOnClickListener(this);
        mButton_c.setOnClickListener(this);
        mButton_v.setOnClickListener(this);
        mButton_b.setOnClickListener(this);
        mButton_n.setOnClickListener(this);
        mButton_m.setOnClickListener(this);
        //        -----------------------------------------------------------------
        findViewById(R.id.button_ض).setOnClickListener(this);
        findViewById(R.id.button_ص).setOnClickListener(this);
        findViewById(R.id.button_ث).setOnClickListener(this);
        findViewById(R.id.button_ق).setOnClickListener(this);
        findViewById(R.id.button_ف).setOnClickListener(this);
        findViewById(R.id.button_غ).setOnClickListener(this);
        findViewById(R.id.button_ع).setOnClickListener(this);
        findViewById(R.id.button_ه).setOnClickListener(this);
        findViewById(R.id.button_خ).setOnClickListener(this);
        findViewById(R.id.button_ح).setOnClickListener(this);
        findViewById(R.id.button_ج).setOnClickListener(this);
        findViewById(R.id.button_ش).setOnClickListener(this);
        findViewById(R.id.button_س).setOnClickListener(this);
        findViewById(R.id.button_ي).setOnClickListener(this);
        findViewById(R.id.button_ب).setOnClickListener(this);
        findViewById(R.id.button_ل).setOnClickListener(this);
        findViewById(R.id.button_ا).setOnClickListener(this);
        findViewById(R.id.button_ت).setOnClickListener(this);
        findViewById(R.id.button_ن).setOnClickListener(this);
        findViewById(R.id.button_م).setOnClickListener(this);
        findViewById(R.id.button_ك).setOnClickListener(this);
        findViewById(R.id.button_ط).setOnClickListener(this);
        findViewById(R.id.button_ذ).setOnClickListener(this);
        findViewById(R.id.button_ء).setOnClickListener(this);
        findViewById(R.id.button_ؤ).setOnClickListener(this);
        findViewById(R.id.button_ر).setOnClickListener(this);
        findViewById(R.id.button_ى).setOnClickListener(this);
        findViewById(R.id.button_ة).setOnClickListener(this);
        findViewById(R.id.button_و).setOnClickListener(this);
        findViewById(R.id.button_ز).setOnClickListener(this);
        findViewById(R.id.button_ظ).setOnClickListener(this);
        findViewById(R.id.button_د).setOnClickListener(this);
        //        -----------------------------------------------------------------
        mButtonDelete.setOnClickListener(this);
        mButtonEnter.setOnClickListener(this);
        mButtonspace.setOnLongClickListener(this);
        mButtonspace.setOnClickListener(this);
//        mButtonplus.setOnClickListener(this);
        mButtondash.setOnClickListener(this);
        mButtondot.setOnClickListener(this);
        mButtonchange.setOnClickListener(this);
        mButtonchangechar.setOnClickListener(this);
        findViewById(R.id.button_delete_ar).setOnClickListener(this);
        findViewById(R.id.button_enter_ar).setOnClickListener(this);
        findViewById(R.id.button_change_ar).setOnClickListener(this);
        findViewById(R.id.button_dash_ar).setOnClickListener(this);
        findViewById(R.id.button_space_ar).setOnClickListener(this);
        findViewById(R.id.button_space_ar).setOnLongClickListener(this);
        findViewById(R.id.button_point_ar).setOnClickListener(this);

//        -----------------------------------------------------------------
        // map buttons IDs to input strings
        keyValues.put(R.id.button_q, "q");
        keyValues.put(R.id.button_w, "w");
        keyValues.put(R.id.button_e, "e");
        keyValues.put(R.id.button_r, "r");
        keyValues.put(R.id.button_t, "t");
        keyValues.put(R.id.button_y, "y");
        keyValues.put(R.id.button_u, "u");
        keyValues.put(R.id.button_i, "i");
        keyValues.put(R.id.button_o, "o");
        keyValues.put(R.id.button_p, "p");
        keyValues.put(R.id.button_a, "a");
        keyValues.put(R.id.button_s, "s");
        keyValues.put(R.id.button_d, "d");
        keyValues.put(R.id.button_f, "f");
        keyValues.put(R.id.button_g, "g");
        keyValues.put(R.id.button_h, "h");
        keyValues.put(R.id.button_j, "j");
        keyValues.put(R.id.button_k, "k");
        keyValues.put(R.id.button_l, "l");
        keyValues.put(R.id.button_z, "z");
        keyValues.put(R.id.button_x, "x");
        keyValues.put(R.id.button_c, "c");
        keyValues.put(R.id.button_v, "v");
        keyValues.put(R.id.button_b, "b");
        keyValues.put(R.id.button_n, "n");
        keyValues.put(R.id.button_m, "m");
        //        -----------------------------------------------------------------
        keyValues.put(R.id.button_ض, "ض");
        keyValues.put(R.id.button_ص, "ص");
        keyValues.put(R.id.button_ث, "ث");
        keyValues.put(R.id.button_ق, "ق");
        keyValues.put(R.id.button_ف, "ف");
        keyValues.put(R.id.button_غ, "غ");
        keyValues.put(R.id.button_ع, "ع");
        keyValues.put(R.id.button_ه, "ه");
        keyValues.put(R.id.button_خ, "خ");
        keyValues.put(R.id.button_ح, "ح");
        keyValues.put(R.id.button_ج, "ج");
        keyValues.put(R.id.button_ش, "ش");
        keyValues.put(R.id.button_س, "س");
        keyValues.put(R.id.button_ي, "ي");
        keyValues.put(R.id.button_ب, "ب");
        keyValues.put(R.id.button_ل, "ل");
        keyValues.put(R.id.button_ا, "ا");
        keyValues.put(R.id.button_ت, "ت");
        keyValues.put(R.id.button_ن, "ن");
        keyValues.put(R.id.button_م, "م");
        keyValues.put(R.id.button_ك, "ك");
        keyValues.put(R.id.button_ط, "ط");
        keyValues.put(R.id.button_ذ, "ذ");
        keyValues.put(R.id.button_ء, "ء");
        keyValues.put(R.id.button_ؤ, "ؤ");
        keyValues.put(R.id.button_ر, "ر");
        keyValues.put(R.id.button_ى, "ى");
        keyValues.put(R.id.button_ة, "ة");
        keyValues.put(R.id.button_و, "و");
        keyValues.put(R.id.button_ز, "ز");
        keyValues.put(R.id.button_ظ, "ظ");
        keyValues.put(R.id.button_د, "د");
        //        -----------------------------------------------------------------
        keyValues.put(R.id.button_space, " ");
        keyValues.put(R.id.button_enter, "\n");
        keyValues.put(R.id.button_plus, "+");
        keyValues.put(R.id.button_dash, "-");
        keyValues.put(R.id.button_point, ".");
        keyValues.put(R.id.button_comma, "'");
        keyValues.put(R.id.button_space_ar, " ");
        keyValues.put(R.id.button_enter_ar, "\n");
        keyValues.put(R.id.button_dash_ar, "،");
        keyValues.put(R.id.button_point_ar, ".");
        //        -----------------------------------------------------------------
        keyValues.put(R.id.button_1, "1");
        keyValues.put(R.id.button_2, "2");
        keyValues.put(R.id.button_3, "3");
        keyValues.put(R.id.button_4, "4");
        keyValues.put(R.id.button_5, "5");
        keyValues.put(R.id.button_6, "6");
        keyValues.put(R.id.button_7, "7");
        keyValues.put(R.id.button_8, "8");
        keyValues.put(R.id.button_9, "9");
        keyValues.put(R.id.button_0, "0");
        keyValues.put(R.id.button_enter_number, "\n");
//        keyValues.put(R.id.button_plus_number, "+");
        keyValues.put(R.id.button_dash_number, "-");
        keyValues.put(R.id.button_point_number, ".");
        keyValues.put(R.id.button_comma_number, "'");
    }



    @Override
    public void onClick(View v) {
        try {
            // do nothing if the InputConnection has not been set yet
            if (inputConnection == null) return;
            // Delete text or input key value
            // All communication goes through the InputConnection
            if (v.getId() == R.id.button_delete || v.getId() == R.id.button_delete_number || v.getId() == R.id.button_delete_ar) {
                CharSequence selectedText = inputConnection.getSelectedText(0);
                if (TextUtils.isEmpty(selectedText)) {
                    // no selection, so delete previous character
                    inputConnection.deleteSurroundingText(1, 0);
                } else {
                    // delete the selection
                    inputConnection.commitText("", 1);
                }
            } else if (v.getId() == R.id.button_enter || v.getId() == R.id.button_enter_number || v.getId() == R.id.button_enter_ar) {
                setVisibility(View.GONE);
            }
            else if (v.getId() == R.id.button_change || v.getId() == R.id.button_change_char || v.getId() == R.id.button_change_ar) {
                if (keychar.getVisibility() == View.VISIBLE) {
                    keynumber.setVisibility(View.VISIBLE);
                    keychar.setVisibility(View.GONE);
                } else {
                    keynumber.setVisibility(View.GONE);
                    keychar.setVisibility(View.VISIBLE);
                }
            }else if(islongpres && (v.getId() == R.id.button_space || v.getId() == R.id.button_space_ar)){
                islongpres=false;
            }
            else {
                String value = keyValues.get(v.getId());
                inputConnection.commitText(value, 1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    // The activity (or some parent or controller) must give us
    // a reference to the current EditText's InputConnection
    public void setInputConnection(InputConnection ic) {
        this.inputConnection = ic;
    }
boolean islongpres=false;
    @Override
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.button_space || view.getId() == R.id.button_space_ar) {
          //  inputConnection.deleteSurroundingText(1, 0);
            islongpres=true;
            if (keycharar.getVisibility() == View.VISIBLE) {
                keycharar.setVisibility(View.GONE);
                keycharen.setVisibility(View.VISIBLE);
//                ((Button) view).setText(R.string.space_tite_ar);
            } else {
                keycharar.setVisibility(View.VISIBLE);
                keycharen.setVisibility(View.GONE);
//                ((Button) view).setText(R.string.space_tite_en);
            }
        }
        return false;
    }
}