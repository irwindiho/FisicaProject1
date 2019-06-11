package com.apps.irdhilmc.fisicaproyect.adapters.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.apps.irdhilmc.fisicaproyect.R;
import com.apps.irdhilmc.fisicaproyect.adapters.FormulasAdapter;
import com.apps.irdhilmc.fisicaproyect.entiites.Formula;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by irvinmarin on 10/06/2019.
 */

public class FormulasViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.txtFormulaText)
    TextView txtFormulaText;


    public FormulasViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Formula formula, final FormulasAdapter.OnItemFormulaClickListener listener) {
        txtFormulaText.setText(formula.getNombreFormula());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickItem(formula);
            }
        });

    }
}
