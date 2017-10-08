package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;
        while (valor % 100 != count) {
            count++;
        }
        valor -= count * 100;
        papeisMoeda[5] = new PapelMoeda(100, count);
        
        count = 0;
        while (valor % 50 != count) {
            count++;
        }
        valor -= count * 50;
        papeisMoeda[4] = new PapelMoeda(50, count);
        
        count = 0;
        while (valor % 20 != count) {
            count++;
        }
        valor -= count * 20;
        papeisMoeda[3] = new PapelMoeda(20, count);
        
        count = 0;
        while (valor % 10 != count) {
            count++;
        }
        valor -= count * 10;
        papeisMoeda[2] = new PapelMoeda(10, count);
        
        count = 0;
        while (valor % 5 != count) {
            count++;
        }
        valor -= count * 5;
        papeisMoeda[1] = new PapelMoeda(5, count);
        
        count = 0;
        while (valor % 2 != count) {
            count++;
        }
        valor -= count * 2;
        papeisMoeda[0] = new PapelMoeda(2, count);
    }

    public TrocoIterator getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        protected Troco troco;
        protected int indice;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
            this.indice = 0;
        }

        @Override
        public boolean hasNext() {
            if(indice < papeisMoeda.length){
                if (troco.papeisMoeda[indice] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 6; i >= 0 && ret != null; i++) {
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                }
            }
            return ret;
        }

        @Override
        public void remove() {
            next();
        }
    }
}
