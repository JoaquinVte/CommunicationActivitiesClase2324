package es.ieslavereda.communicationactivitiesclase2324;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CustomGradeView extends ConstraintLayout {

    private ProgressBar progressBar;
    private TextView textView;
    private Color barColor;
    private Color textColor;
    private float textSize;

    public CustomGradeView(@NonNull Context context) {
        super(context);
        init();
    }

    public CustomGradeView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomGradeView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    public CustomGradeView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if(widthMeasureSpec!=0 || heightMeasureSpec!=0) {

            int size = Math.max(widthMeasureSpec, heightMeasureSpec);

            setMeasuredDimension(size, size);

        }
    }

    public void init(){
        textColor = Color.DEFAULT;
        barColor = Color.DEFAULT;

        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.my_grade_view,this,true);

        progressBar = view.findViewById(R.id.puntuacionGraf);
        textView = view.findViewById(R.id.puntuacionNum);

    }

    public void init(AttributeSet attrs){
        init();

        if(attrs!=null) {
            TypedArray styledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.CustomGradeView);

            int grade = styledAttributes
                    .getInt(R.styleable.CustomGradeView_grade, 100);
            int barColor = styledAttributes
                    .getColor(R.styleable.CustomGradeView_barColor, getContext().getTheme().getResources().getColor(com.google.android.material.R.color.design_default_color_primary,getContext().getTheme()));
            int textColor = styledAttributes
                    .getColor(R.styleable.CustomGradeView_textColor, getContext().getTheme().getResources().getColor(com.google.android.material.R.color.design_default_color_primary,getContext().getTheme()));
            textSize = styledAttributes
                    .getDimensionPixelSize(R.styleable.CustomGradeView_textSize, 0);

            styledAttributes.recycle();

            setGrade(grade);
            progressBar.getProgressDrawable().setColorFilter(barColor, PorterDuff.Mode.SRC_IN );
            textView.setTextColor(textColor);

            if(textSize>0)
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX,textSize);
        }
    }

    public void up(){
        int grade = progressBar.getProgress();
        if(grade<100)
            setGrade(++grade);
    }
    public void down(){
        int grade = progressBar.getProgress();
        if(grade>0)
            setGrade(--grade);
    }

    public void setGrade(int grade){

        if(grade>100) grade=100;
        if(grade<0) grade = 0;

        progressBar.setProgress(grade);
        textView.setText(String.valueOf(grade));
    }

    public void setBarColor(int color){
        progressBar.getProgressDrawable().setColorFilter(getContext().getColor(color), PorterDuff.Mode.SRC_IN);
    }

    public void setBarColor(Color color){
        this.barColor=color;
        setBarColor(color.getValue());
    }

    public void setTextColor(int color){
        textView.setTextColor(getContext().getColor(color));
    }

    public void setTextColor(Color color){
        this.textColor = color;
        setTextColor(color.getValue());
    }

    public void setTextSize(int size){
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,size);
    }


    public int getGrade() {
        return progressBar.getProgress();
    }

    public Color getBarColor() {
        return barColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public float getTextSize() {
        return textSize;
    }
}
