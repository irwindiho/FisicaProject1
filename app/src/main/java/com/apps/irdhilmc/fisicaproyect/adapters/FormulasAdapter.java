package com.apps.irdhilmc.fisicaproyect.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apps.irdhilmc.fisicaproyect.R;
import com.apps.irdhilmc.fisicaproyect.adapters.holders.FormulasViewHolder;
import com.apps.irdhilmc.fisicaproyect.entiites.Formula;

import java.util.List;

import butterknife.BindView;

/**
 * Created by irvinmarin on 10/06/2019.
 */

public class FormulasAdapter extends RecyclerView.Adapter<FormulasViewHolder> {


    private List<Formula> formulaList;
    private OnItemFormulaClickListener listener;

    public FormulasAdapter(List<Formula> formulaList, OnItemFormulaClickListener listener) {
        this.formulaList = formulaList;
        this.listener = listener;
    }

    public interface OnItemFormulaClickListener {
        void onClickItem(Formula formula);
    }


    @NonNull
    @Override
    public FormulasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_formula, parent, false);
        return new FormulasViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FormulasViewHolder holder, int position) {
        holder.bind(formulaList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return formulaList.size();
    }
}
