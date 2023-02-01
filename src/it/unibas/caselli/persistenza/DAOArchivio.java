package it.unibas.caselli.persistenza;

import it.unibas.caselli.modello.Accesso;
import it.unibas.caselli.modello.Archivio;
import it.unibas.caselli.modello.Casello;
import it.unibas.caselli.modello.Costanti;

public class DAOArchivio implements IDAOArchivio {

    @Override
    public Archivio carica(String file) throws DAOException {

        Archivio archivio = new Archivio();

        Casello casello1 = new Casello("A1NN", "Autostrada A1", 150.32);
        Casello casello2 = new Casello("A3NN", "Autostrada A1", 174.32);
        Casello casello3 = new Casello("A5NN", "Autostrada A1", 185.18);
        Casello casello4 = new Casello("A5NN", "Autostrada A2", 185.18);

        casello1.addAccesso(new Accesso("18AG22", "FIAT", 20.50, Costanti.CARTA));
        casello1.addAccesso(new Accesso("46BO12", "ALFA ROMEO", 21.50, Costanti.CONTANTI));
        casello1.addAccesso(new Accesso("90AE32", "AUDI", 22.50, Costanti.CONTANTI));
        casello1.addAccesso(new Accesso("90AE32", "AUDI", 22.50, Costanti.CONTANTI));
        casello1.addAccesso(new Accesso("90AE32", "AUDI", 22.50, Costanti.CONTANTI));
        casello1.addAccesso(new Accesso("90AE32", "AUDI", 22.50, Costanti.CONTANTI));
        casello1.addAccesso(new Accesso("90AE32", "AUDI", 22.50, Costanti.CONTANTI));
        casello1.addAccesso(new Accesso("90AE32", "AUDI", 22.50, Costanti.CONTANTI));
        casello1.addAccesso(new Accesso("90AE32", "AUDI", 22.50, Costanti.CONTANTI));
        casello1.addAccesso(new Accesso("90AE32", "AUDI", 22.50, Costanti.CONTANTI));
        casello1.addAccesso(new Accesso("90AE32", "AUDI", 22.50, Costanti.CONTANTI));

        casello2.addAccesso(new Accesso("18AG22", "FIAT", 20.50, Costanti.CARTA));
        casello2.addAccesso(new Accesso("18AG22", "FIAT", 20.50, Costanti.CARTA));
        casello2.addAccesso(new Accesso("90AE32", "AUDI", 22.50, Costanti.CONTANTI));

        casello3.addAccesso(new Accesso("46BO12", "ALFA ROMEO", 21.50, Costanti.CONTANTI));
        casello3.addAccesso(new Accesso("46BO12", "ALFA ROMEO", 21.50, Costanti.CONTANTI));
        casello3.addAccesso(new Accesso("46BO12", "ALFA ROMEO", 21.50, Costanti.CONTANTI));
        casello3.addAccesso(new Accesso("90AE32", "AUDI", 22.50, Costanti.CONTANTI));

        casello4.addAccesso(new Accesso("90AE32", "AUDI", 22.50, Costanti.CONTANTI));
        casello4.addAccesso(new Accesso("90AE32", "AUDI", 22.50, Costanti.CONTANTI));

        archivio.addCasello(casello1);
        archivio.addCasello(casello2);
        archivio.addCasello(casello3);
        archivio.addCasello(casello4);

        return archivio;
    }

}
