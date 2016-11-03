
--DELETE TABLES
drop table hm_reserva;
drop table hm_habitacion;
drop table hm_usuario;
drop table hm_persona;
drop table hm_tipohabitacion;
drop table hm_hotel;
commit;

--CREATE TABLES
CREATE TABLE HM_HABITACION
  (
    habi_id   NUMBER NOT NULL ,
    habi_codi CHAR (5) NOT NULL ,
    tiph_id   NUMBER NOT NULL
  ) ;
ALTER TABLE HM_HABITACION ADD CONSTRAINT HM_HABITACION_PK PRIMARY KEY ( habi_id ) ;
CREATE TABLE HM_HOTEL
  (
    hote_id   NUMBER NOT NULL ,
    hote_nomb VARCHAR2 (50) NOT NULL ,
    hote_desc VARCHAR2 (100) ,
    hote_cate VARCHAR2 (50) ,
    hote_dire VARCHAR2 (50) ,
    hote_pobl VARCHAR2 (50) ,
    hote_prov VARCHAR2 (50) ,
    hote_codp VARCHAR2 (6) ,
    hote_telf VARCHAR2 (20)
  ) ;
ALTER TABLE HM_HOTEL ADD CONSTRAINT HM_HOTEL_PK PRIMARY KEY ( hote_id ) ;
CREATE TABLE HM_PERSONA
  (
    --pers_id   NUMBER GENERATED AS IDENTITY,
	pers_id   NUMBER,
    pers_nomb VARCHAR2 (50) NOT NULL ,
    pers_apel VARCHAR2 (50) NOT NULL ,
    pers_dire VARCHAR2 (50) ,
    pers_pobl VARCHAR2 (50) ,
    pers_prov VARCHAR2 (50) ,
    pers_codp VARCHAR2 (6) ,
    pers_telf VARCHAR2 (20)
  ) ;
ALTER TABLE HM_PERSONA ADD CONSTRAINT HM_CLIENTE_PK PRIMARY KEY ( pers_id ) ;
CREATE TABLE HM_RESERVA
  (
    rese_id   NUMBER NOT NULL ,
    rese_fini DATE NOT NULL ,
    rese_ffin DATE NOT NULL ,
    rese_tota NUMBER (10,2) NOT NULL ,
    clie_id   NUMBER NOT NULL ,
    empl_id   NUMBER ,
    habi_id   NUMBER NOT NULL ,
    rese_esta CHAR (1) NOT NULL
  ) ;
ALTER TABLE HM_RESERVA ADD CONSTRAINT HM_RESERVA_PK PRIMARY KEY ( rese_id ) ;
CREATE TABLE HM_TIPOHABITACION
  (
    tiph_id   NUMBER NOT NULL ,
    tiph_nomb VARCHAR2 (50) NOT NULL ,
    tiph_desc VARCHAR2 (50) NOT NULL ,
    tiph_cpac NUMBER ,
    tiph_prec NUMBER (10,2) NOT NULL ,
    hote_id   NUMBER NOT NULL
  ) ;
ALTER TABLE HM_TIPOHABITACION ADD CONSTRAINT HM_TIPO_HABITACION_PK PRIMARY KEY ( tiph_id ) ;
CREATE TABLE HM_USUARIO
  (
    user_id   NUMBER NOT NULL ,
    user_user VARCHAR2 (20) NOT NULL ,
    user_pass VARCHAR2 (20) NOT NULL ,
    user_emai VARCHAR2 (30) NOT NULL ,
    user_freg DATE NOT NULL ,
    user_facc DATE ,
    user_esta CHAR (1) NOT NULL ,
    user_rol  CHAR (1) NOT NULL ,
    pers_id   NUMBER NOT NULL
  ) ;
ALTER TABLE HM_USUARIO ADD CONSTRAINT HM_USUARIO_PK PRIMARY KEY ( user_id ) ;
--ALTER TABLE HM_USUARIO ADD CONSTRAINT HM_USUARIO__UN_EMAI UNIQUE ( user_emai ) ;
ALTER TABLE HM_USUARIO ADD CONSTRAINT HM_USUARIO__UN_PERS_ROL UNIQUE ( pers_id , user_rol ) ;
--ALTER TABLE HM_USUARIO ADD CONSTRAINT HM_USUARIO__UN_USER UNIQUE ( user_user ) ;
ALTER TABLE HM_HABITACION ADD CONSTRAINT HM_HABITACION_HM_TIPO_FK FOREIGN KEY ( tiph_id ) REFERENCES HM_TIPOHABITACION ( tiph_id ) ;
ALTER TABLE HM_RESERVA ADD CONSTRAINT HM_RESERVA_HM_HABITACION_FK FOREIGN KEY ( habi_id ) REFERENCES HM_HABITACION ( habi_id ) ;
ALTER TABLE HM_RESERVA ADD CONSTRAINT HM_RESERVA_HM_USUARIO_CLIE FOREIGN KEY ( clie_id ) REFERENCES HM_USUARIO ( user_id ) ;
ALTER TABLE HM_RESERVA ADD CONSTRAINT HM_RESERVA_HM_USUARIO_EMPL FOREIGN KEY ( empl_id ) REFERENCES HM_USUARIO ( user_id ) ;
ALTER TABLE HM_TIPOHABITACION ADD CONSTRAINT HM_TIPOHABITACION_HM_HOTEL_FK FOREIGN KEY ( hote_id ) REFERENCES HM_HOTEL ( hote_id ) ;
ALTER TABLE HM_USUARIO ADD CONSTRAINT HM_USUARIO_HM_PERSONA_FK FOREIGN KEY ( pers_id ) REFERENCES HM_PERSONA ( pers_id ) ;
commit;

















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
  
  
  
    ---#SEQUENCES
  drop sequence hm_hotel_seq;
  CREATE SEQUENCE hm_hotel_seq
  MINVALUE 1
  MAXVALUE 999999999999999999999999999
  START WITH 1
  INCREMENT BY 1
  CACHE 20;
  commit;
 
  drop sequence hm_tipohabitacion_seq;
  CREATE SEQUENCE hm_tipohabitacion_seq
  MINVALUE 3
  MAXVALUE 999999999999999999999999999
  START WITH 3
  INCREMENT BY 1
  CACHE 20;
  commit;
  
  drop sequence hm_habitacion_seq;
  CREATE SEQUENCE hm_habitacion_seq
  MINVALUE 3
  MAXVALUE 999999999999999999999999999
  START WITH 3
  INCREMENT BY 1
  CACHE 20;
  commit;
  
  drop sequence hm_persona_seq;
  CREATE SEQUENCE hm_persona_seq
  MINVALUE 6
  MAXVALUE 999999999999999999999999999
  START WITH 6
  INCREMENT BY 1
  CACHE 20;
  commit;
  
  drop sequence hm_usuario_seq;
  CREATE SEQUENCE hm_usuario_seq
  MINVALUE 5
  MAXVALUE 999999999999999999999999999
  START WITH 5
  INCREMENT BY 1
  CACHE 20;
  commit;
  
  drop sequence hm_reserva_seq;
  CREATE SEQUENCE hm_reserva_seq
  MINVALUE 3
  MAXVALUE 999999999999999999999999999
  START WITH 3
  INCREMENT BY 1
  CACHE 20;
  commit;
  
  
  select * from hm_persona;
   select * from hm_usuario;
