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