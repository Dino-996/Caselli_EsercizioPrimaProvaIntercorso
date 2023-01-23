package it.unibas.caselli.persistenza;

import it.unibas.caselli.modello.Archivio;

public interface IDAOArchivio {

    Archivio carica(String file) throws DAOException;
}
