package com.example.firsttask;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.firsttask.fragments.CurrencyRates;
import com.example.firsttask.fragments.IbanValidator;

public class MyViewPagerAdapter extends FragmentStateAdapter {
    public MyViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 1:
                return new IbanValidator();
            case 0:
                return new CurrencyRates();
            default:
                return new IbanValidator();
        }

    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
