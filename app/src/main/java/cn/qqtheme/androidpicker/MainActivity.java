package cn.qqtheme.androidpicker;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.github.florent37.viewanimator.ViewAnimator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import cn.qqtheme.framework.picker.AddressPicker;
import cn.qqtheme.framework.picker.ChineseZodiacPicker;
import cn.qqtheme.framework.picker.ColorPicker;
import cn.qqtheme.framework.picker.ConstellationPicker;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.FilePicker;
import cn.qqtheme.framework.picker.MyTimePicker;
import cn.qqtheme.framework.picker.NumberPicker;
import cn.qqtheme.framework.picker.OptionPicker;
import cn.qqtheme.framework.picker.SexPicker;
import cn.qqtheme.framework.picker.TimePicker;
import cn.qqtheme.framework.util.ConvertUtils;
import cn.qqtheme.framework.util.StorageUtils;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onBackPressed() {
        System.exit(0);
        android.os.Process.killProcess(android.os.Process.myPid());
        finish();
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void onAnimationStyle(View view) {
        NumberPicker picker = new NumberPicker(this);
        picker.setAnimationStyle(R.style.Animation_CustomPopup);
        picker.setOffset(2);//偏移量
        picker.setRange(40, 100);//数字范围
        picker.setSelectedItem(65);
        picker.setLabel("Kg");
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(String option) {
                showToast(option);
            }
        });
        picker.show();
    }

    public void onAnimator(View view) {
        CustomHeaderAndFooterPicker picker = new CustomHeaderAndFooterPicker(this);
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(String option) {
                showToast(option);
            }
        });
        picker.show();
    }

    public void onYearMonthDayPicker(View view) {
        DatePicker picker = new DatePicker(this);
        picker.setRange(2000, 2016);
        picker.setSelectedItem(2015, 10, 10);
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                showToast(year + "-" + month + "-" + day);
            }
        });
        picker.show();
    }

    public void onYearMonthPicker(View view) {
        DatePicker picker = new DatePicker(this, DatePicker.YEAR_MONTH);
        picker.setRange(1990, 2015);
        picker.setOnDatePickListener(new DatePicker.OnYearMonthPickListener() {
            @Override
            public void onDatePicked(String year, String month) {
                showToast(year + "-" + month);
            }
        });
        picker.show();
    }

    public void onMonthDayPicker(View view) {
        DatePicker picker = new DatePicker(this, DatePicker.MONTH_DAY);
        picker.setOnDatePickListener(new DatePicker.OnMonthDayPickListener() {
            @Override
            public void onDatePicked(String month, String day) {
                showToast(month + "-" + day);
            }
        });
        picker.show();
    }

    public void onTimePicker(View view) {
        //默认选中当前时间
        TimePicker picker = new TimePicker(this, TimePicker.HOUR_OF_DAY);
        picker.setTopLineVisible(false);
        picker.setOnTimePickListener(new TimePicker.OnTimePickListener() {
            @Override
            public void onTimePicked(String hour, String minute) {
                showToast(hour + ":" + minute);
            }
        });
        picker.show();
    }

    public void onOptionPicker(View view) {
        OptionPicker picker = new OptionPicker(this, new String[]{
                "第一项", "第二项", "这是一个很长很长很长很长很长很长很长很长很长的很长很长的很长很长的项"
        });
        picker.setOffset(2);
        picker.setSelectedIndex(1);
        picker.setTextSize(11);
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(String option) {
                showToast(option);
            }
        });
        picker.show();
    }

    public void onConstellationPicker(View view) {
        ConstellationPicker picker = new ConstellationPicker(this);
        picker.setTopBackgroundColor(0xFFEEEEEE);
        picker.setTopLineVisible(false);
        picker.setCancelTextColor(0xFF33B5E5);
        picker.setSubmitTextColor(0xFF33B5E5);
        picker.setTextColor(0xFFFF0000, 0xFFCCCCCC);
        picker.setLineColor(0xFFEE0000);
        picker.setSelectedItem("射手");
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(String option) {
                showToast(option);
            }
        });
        picker.show();
    }

    public void onChineseZodiacPicker(View view) {
        ChineseZodiacPicker picker = new ChineseZodiacPicker(this);
        picker.setLineVisible(false);
        picker.setSelectedItem("羊");
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(String option) {
                showToast(option);
            }
        });
        picker.show();
    }

    public void onNumberPicker(View view) {
        NumberPicker picker = new NumberPicker(this);
        picker.setOffset(2);//偏移量
        picker.setRange(145, 200);//数字范围
        picker.setSelectedItem(172);
        picker.setLabel("厘米");
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(String option) {
                showToast(option);
            }
        });
        picker.show();
    }

    public void onSexPicker(View view) {
        SexPicker picker = new SexPicker(this);
        //picker.onlyMaleAndFemale();
        picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
            @Override
            public void onOptionPicked(String option) {
                showToast(option);
            }
        });
        picker.show();
    }

    public void onAddressPicker(View view) {
        new AddressInitTask(this).execute("贵州", "毕节", "纳雍");
    }

    public void onAddress2Picker(View view) {
        try {
            ArrayList<AddressPicker.Province> data = new ArrayList<AddressPicker.Province>();
            String json = AssetsUtils.readText(this, "city2.json");
            data.addAll(JSON.parseArray(json, AddressPicker.Province.class));
            AddressPicker picker = new AddressPicker(this, data);
            picker.setHideProvince(true);
            picker.setSelectedItem("贵州", "贵阳", "花溪");
            picker.setOnAddressPickListener(new AddressPicker.OnAddressPickListener() {
                @Override
                public void onAddressPicked(String province, String city, String county) {
                    showToast(city + county);
                }
            });
            picker.show();
        } catch (Exception e) {
            showToast(e.toString());
        }
    }


    public void onAddress3Picker(View view) {
        new AddressInitTask(this,true).execute("四川", "成都");
    }

    public void onColorPicker(View view) {
        ColorPicker picker = new ColorPicker(this);
        picker.setInitColor(0xDD00DD);
        picker.setOnColorPickListener(new ColorPicker.OnColorPickListener() {
            @Override
            public void onColorPicked(int pickedColor) {
                showToast(ConvertUtils.toColorString(pickedColor));
            }
        });
        picker.show();
    }

    public void onFilePicker(View view) {
        //noinspection MissingPermission
        FilePicker picker = new FilePicker(this, FilePicker.FILE);
        picker.setShowHideDir(false);
        //picker.setAllowExtensions(new String[]{".apk"});
        picker.setOnFilePickListener(new FilePicker.OnFilePickListener() {
            @Override
            public void onFilePicked(String currentPath) {
                showToast(currentPath);
            }
        });
        picker.show();
    }

    public void onDirPicker(View view) {
        //noinspection MissingPermission
        FilePicker picker = new FilePicker(this, FilePicker.DIRECTORY);
        picker.setRootPath(StorageUtils.getRootPath(this) + "Download/");
        picker.setOnFilePickListener(new FilePicker.OnFilePickListener() {
            @Override
            public void onFilePicked(String currentPath) {
                showToast(currentPath);
            }
        });
        picker.show();
    }

    public void onContact(View view) {
        final ArrayList<String> minutes =  get64minutes();
        final ArrayList<String> hours = get24hours();
        final ArrayList<String> dates = get7Date();

        MyTimePicker myTimePicker=new MyTimePicker(this,dates,hours,minutes);
        myTimePicker.setSelectedItem(0,0,0);
        myTimePicker.setTitleText("选择时间");
        myTimePicker.setTitleTextSize(16);

        myTimePicker.setTopBackgroundColor(Color.parseColor("#FFEAEAEB"));
        myTimePicker.setTextSize(21);

        myTimePicker.setCancelText("取消");
        myTimePicker.setSubmitText("完成");
        myTimePicker.setSubmitTextColor(Color.parseColor("#F77B55"));
        myTimePicker.setLineColor(Color.parseColor("#FFEAEAEB"));
        myTimePicker.setTextColor(Color.parseColor("#000000"));
        myTimePicker.show();
        myTimePicker.setOnAddressPickListener(new MyTimePicker.OnAddressPickListener() {
            @Override
            public void onAddressPicked(String province, String city, String county) {
                System.out.println("province="+province);
                System.out.println("city="+city);
                System.out.println("county="+county);
            }
        });



//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:liyujiang_tk@yeah.net"));
//        intent.putExtra(Intent.EXTRA_CC, new String[]
//                {"1032694760@qq.com"});
//        intent.putExtra(Intent.EXTRA_EMAIL, "");
//        intent.putExtra(Intent.EXTRA_TEXT, "欢迎提供意您的见或建议");
//        startActivity(Intent.createChooser(intent, "选择邮件客户端"));
    }
    private ArrayList<String> get7Date() {
        ArrayList<String> dates = new ArrayList<String>();
        for (int i = 0; i < 7; i++) {
            dates.add(getStatetime(i));
        }
        return dates;
    }

    private ArrayList<String> get24hours() {
        ArrayList<String> dates = new ArrayList<String>();
        for (int i = 0; i < 24; i++) {

            dates.add((i < 10 ? "0" + i : i) + "时");
        }
        return dates;
    }

    private ArrayList<String> get64minutes() {
        ArrayList<String> dates = new ArrayList<String>();
        for (int i = 0; i < 60; i++) {
            dates.add((i < 10 ? "0" + i : i) + "分");
        }
        return dates;
    }

    private String getStatetime(int i) {

        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, i);
        Date monday = c.getTime();
        String preMonday = sdf.format(monday);
        return preMonday;
    }

}
