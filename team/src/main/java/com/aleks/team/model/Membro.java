package com.aleks.team.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Getter
@Setter
@Entity
public class Membro {

    @Id
    private Long codigo;

    private String posicao;

    private String experiencia;

    private String nome;

    private int idade;

    private byte[] foto;

    public static List<Membro[]> ordenarMembros(List<Membro> membrosEntrada){

        List<Membro> membrosRetorno = new ArrayList<Membro>();
        List<Membro> membrosIntermediario = new ArrayList<Membro>();

        Membro membroTcl = null;
        Membro membroPm = null;
        Membro membroAux;

        Iterator<Membro> it = membrosEntrada.iterator();

        while(it.hasNext()){
            membroAux = it.next();

            System.out.println(membroAux);

            if(membroAux.getPosicao().equals("TCL")){
                membroTcl = membroAux;
            }else if(membroAux.getPosicao().equals("PM")){
                membroPm = membroAux;
            }else{
                membrosIntermediario.add(membroAux);
            }
        }

        if(membroTcl != null){
            membrosRetorno.add(membroTcl);
        }

        if(membroPm != null){
            membrosRetorno.add(membroPm);
        }

        membrosRetorno.addAll(membrosIntermediario);

        return membrosPaginados(membrosRetorno);

    }

    private static List<Membro[]> membrosPaginados(List<Membro> lstEntrada){

        List<Membro[]> listaRetorno = new ArrayList<Membro[]>();

        Iterator<Membro> it = lstEntrada.iterator();

        while(it.hasNext()){

            Membro[] membros = new Membro[3];

            for(int j = 0; j <= 2; ++j){

                membros[j] = it.next();

            }

            listaRetorno.add(membros);

        }

        return listaRetorno;

    }

}
