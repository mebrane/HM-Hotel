---### TABLE HM_HOTEL
INSERT
INTO HM_HOTEL
  (
    HOTE_ID,
    HOTE_CODP,
    HOTE_PROV,
    HOTE_TELF,
    HOTE_DIRE,
    HOTE_CATE,
    HOTE_DESC,
    HOTE_POBL,
    HOTE_NOMB
  )
  VALUES
  (
    1,
    'Cod.P.',
    'Prov. H.',
    'Telf. H.',
    'Dir. H.',
    'Cate H.',
    'Desc. H.',
    'Pobl. H.',
    'Nomb. H.'
  );
  commit;
  

  
--### TIPOHABITACION
  INSERT
INTO HM_TIPOHABITACION
  (
    TIPH_ID,
    HOTE_ID,
    TIPH_NOMB,
    TIPH_CPAC,
    TIPH_DESC,
    TIPH_PREC
  )
  VALUES
  (
    1,
    1,
    'Tipo 1',
    '1',
    'Desc. 1',
    10
  );  
  commit;

  INSERT
INTO HM_TIPOHABITACION
  (
    TIPH_ID,
    HOTE_ID,
    TIPH_NOMB,
    TIPH_CPAC,
    TIPH_DESC,
    TIPH_PREC
  )
  VALUES
  (
    2,
    1,
    'Tipo 2',
    '2',
    'Desc. 2',
    20
  );
  commit;

  
--### HABITACION
INSERT INTO HM_HABITACION
  (HABI_ID, TIPH_ID, HABI_CODI
  ) VALUES
  (1, 2, 'H0001');
  commit;
  
  INSERT INTO HM_HABITACION
  (HABI_ID, TIPH_ID, HABI_CODI
  ) VALUES
  (2, 1, 'H0002');
  commit;
  
--### PERSONA
  
  INSERT
INTO HM_PERSONA
  (
    PERS_ID,
    PERS_PROV,
    PERS_NOMB,
    PERS_DIRE,
    PERS_POBL,
    PERS_CODP,
    PERS_APEL,
    PERS_TELF
  )
  VALUES
  (
    1,
    'Prov. 1',
    'Nomb. 1',
    'Dire. 1',
    'Pobl. 1',
    'C.P.1',
    'Apel. 1',
    'Telf. 1'
  );
  commit;
  
  INSERT
INTO HM_PERSONA
  (
    PERS_ID,
    PERS_PROV,
    PERS_NOMB,
    PERS_DIRE,
    PERS_POBL,
    PERS_CODP,
    PERS_APEL,
    PERS_TELF
  )
  VALUES
  (
    2,
    'Prov. 2',
    'Nomb. 2',
    'Dire. 2',
    'Pobl. 2',
    'C.P.2',
    'Apel. 2',
    'Telf. 2'
  );
  commit;
  
    INSERT
INTO HM_PERSONA
  (
    PERS_ID,
    PERS_PROV,
    PERS_NOMB,
    PERS_DIRE,
    PERS_POBL,
    PERS_CODP,
    PERS_APEL,
    PERS_TELF
  )
  VALUES
  (
    3,
    'Prov. 3',
    'Nomb. 3',
    'Dire. 3',
    'Pobl. 3',
    'C.P.3',
    'Apel. 3',
    'Telf. 3'
  );
  commit;
  
  
    INSERT
INTO HM_PERSONA
  (
    PERS_ID,
    PERS_PROV,
    PERS_NOMB,
    PERS_DIRE,
    PERS_POBL,
    PERS_CODP,
    PERS_APEL,
    PERS_TELF
  )
  VALUES
  (
    4,
    'Prov. 4',
    'Nomb. 4',
    'Dire. 4',
    'Pobl. 4',
    'C.P.4',
    'Apel. 4',
    'Telf. 4'
  );
  commit;
  
    INSERT
INTO HM_PERSONA
  (
    PERS_ID,
    PERS_PROV,
    PERS_NOMB,
    PERS_DIRE,
    PERS_POBL,
    PERS_CODP,
    PERS_APEL,
    PERS_TELF
  )
  VALUES
  (
    5,
    'Prov. 5',
    'Nomb. 5',
    'Dire. 5',
    'Pobl. 5',
    'C.P.5',
    'Apel. 5',
    'Telf. 5'
  );
  commit;
  
---### USUARIO
  INSERT
INTO HM_USUARIO
  (
    USER_ID,
    USER_FACC,
    USER_FREG,
    USER_EMAI,
    USER_ROL,
    PERS_ID,
    USER_PASS,
    USER_ESTA,
    USER_USER
  )
  VALUES
  (
    1,
    null,
    sysdate,
    'user1@email.com',
    'A',
    1,
    'admin',
    'A',
    'admin'
  );
  
  commit;
   
    INSERT
INTO HM_USUARIO
  (
    USER_ID,
    USER_FACC,
    USER_FREG,
    USER_EMAI,
    USER_ROL,
    PERS_ID,
    USER_PASS,
    USER_ESTA,
    USER_USER
  )
  VALUES
  (
    2,
    null,
    sysdate,
    'user2@email.com',
    'C',
    1,
    '11111',
    'A',
    'clie1'
  );
  
  commit;
  
   INSERT
INTO HM_USUARIO
  (
    USER_ID,
    USER_FACC,
    USER_FREG,
    USER_EMAI,
    USER_ROL,
    PERS_ID,
    USER_PASS,
    USER_ESTA,
    USER_USER
  )
  VALUES
  (
    3,
    null,
    sysdate,
    'user3@email.com',
    'C',
    2,
    '22222',
    'A',
    'clie2'
  );
  
  commit;
  
   INSERT
INTO HM_USUARIO
  (
    USER_ID,
    USER_FACC,
    USER_FREG,
    USER_EMAI,
    USER_ROL,
    PERS_ID,
    USER_PASS,
    USER_ESTA,
    USER_USER
  )
  VALUES
  (
    4,
    null,
    sysdate,
    'user4@email.com',
    'C',
    5,
    '33333',
    'A',
    'clie3'
  );
  commit;


INSERT
INTO HM_RESERVA
  (
    RESE_ID,
    HABI_ID,
    CLIE_ID,
    RESE_ESTA,
    EMPL_ID,
    RESE_TOTA,
    RESE_FINI,
    RESE_FFIN
  )
  VALUES
  (
    1,
    2,
    3,
    'R',
    null,
    20,
    '27/10/16',
    '29/10/16'
  );
  commit;


INSERT
INTO HM_RESERVA
  (
    RESE_ID,
    HABI_ID,
    CLIE_ID,
    RESE_ESTA,
    EMPL_ID,
    RESE_TOTA,
    RESE_FINI,
    RESE_FFIN
  )
  VALUES
  (
    2,
    2,
    4,
    'P',
    1,
    20,
    '27/10/16',
    '28/10/16'
  );
  commit;
  