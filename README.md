drop table hm_reserva;


drop table hm_habitacion;


drop table hm_usuario;


drop table hm_persona;


drop table hm_tipohabitacion;


drop table hm_hotel;


commit;


create table hm_habitacion ( habi_id NUMBER not null, habi_codi CHAR (5) not null, tiph_id NUMBER not null ) ;


alter table hm_habitacion add constraint hm_habitacion_pk primary key (habi_id) ;


create table hm_hotel ( hote_id NUMBER not null, hote_nomb VARCHAR2 (50) not null, hote_desc VARCHAR2 (100), hote_cate VARCHAR2 (50), hote_dire VARCHAR2 (50), hote_pobl VARCHAR2 (50), hote_prov VARCHAR2 (50), hote_codp VARCHAR2 (6), hote_telf VARCHAR2 (20) ) ;


alter table hm_hotel add constraint hm_hotel_pk primary key (hote_id) ;


create table hm_persona ( pers_id NUMBER, pers_nomb VARCHAR2 (50) not null, pers_apel VARCHAR2 (50) not null, pers_dire VARCHAR2 (50), pers_pobl VARCHAR2 (50), pers_prov VARCHAR2 (50), pers_codp VARCHAR2 (6), pers_telf VARCHAR2 (20) ) ;


alter table hm_persona add constraint hm_cliente_pk primary key (pers_id) ;


create table hm_reserva ( rese_id NUMBER not null, rese_fini DATE not null, rese_ffin DATE not null, rese_tota NUMBER (10,2) not null, clie_id NUMBER not null, empl_id NUMBER , habi_id NUMBER not null, rese_esta CHAR (1) not null ) ;


alter table hm_reserva add constraint hm_reserva_pk primary key (rese_id) ;


create table hm_tipohabitacion ( tiph_id NUMBER not null, tiph_nomb VARCHAR2 (50) not null, tiph_desc VARCHAR2 (50) not null, tiph_cpac NUMBER , tiph_prec NUMBER (10,2) not null, hote_id NUMBER not null ) ;


alter table hm_tipohabitacion add constraint hm_tipo_habitacion_pk primary key (tiph_id) ;


create table hm_usuario ( user_id NUMBER not null, user_user VARCHAR2 (20) not null, user_pass VARCHAR2 (20) not null, user_emai VARCHAR2 (30) not null, user_freg DATE not null, user_facc DATE , user_esta CHAR (1) not null, user_rol CHAR (1) not null, pers_id NUMBER not null ) ;


alter table hm_usuario add constraint hm_usuario_pk primary key (user_id) ;


alter table hm_usuario add constraint hm_usuario__un_pers_rol unique (pers_id,
                                                                      user_rol) ;


alter table hm_habitacion add constraint hm_habitacion_hm_tipo_fk
foreign key (tiph_id) references hm_tipohabitacion (tiph_id) ;


alter table hm_reserva add constraint hm_reserva_hm_habitacion_fk
foreign key (habi_id) references hm_habitacion (habi_id) ;


alter table hm_reserva add constraint hm_reserva_hm_usuario_clie
foreign key (clie_id) references hm_usuario (user_id) ;


alter table hm_reserva add constraint hm_reserva_hm_usuario_empl
foreign key (empl_id) references hm_usuario (user_id) ;


alter table hm_tipohabitacion add constraint hm_tipohabitacion_hm_hotel_fk
foreign key (hote_id) references hm_hotel (hote_id) ;


alter table hm_usuario add constraint hm_usuario_hm_persona_fk
foreign key (pers_id) references hm_persona (pers_id) ;


commit;


insert into hm_hotel ( hote_id, hote_codp, hote_prov, hote_telf, hote_dire, hote_cate, hote_desc, hote_pobl, hote_nomb )
values ( 1,
         'Cod.P.',
         'Prov. H.',
         'Telf. H.',
         'Dir. H.',
         'Cate H.',
         'Desc. H.',
         'Pobl. H.',
         'Nomb. H.' );


commit;


insert into hm_tipohabitacion ( tiph_id, hote_id, tiph_nomb, tiph_cpac, tiph_desc, tiph_prec )
values ( 1,
         1,
         'Tipo 1',
         '1',
         'Desc. 1',
         10 );

commit;


insert into hm_tipohabitacion ( tiph_id, hote_id, tiph_nomb, tiph_cpac, tiph_desc, tiph_prec )
values ( 2,
         1,
         'Tipo 2',
         '2',
         'Desc. 2',
         20 );


commit;


insert into hm_habitacion (habi_id, tiph_id, habi_codi )
values (1,
        2,
        'H0001');


commit;


insert into hm_habitacion (habi_id, tiph_id, habi_codi )
values (2,
        1,
        'H0002');


commit;


insert into hm_persona ( pers_id, pers_prov, pers_nomb, pers_dire, pers_pobl, pers_codp, pers_apel, pers_telf )
values ( 1,
         'Prov. 1',
         'Nomb. 1',
         'Dire. 1',
         'Pobl. 1',
         'C.P.1',
         'Apel. 1',
         'Telf. 1' );


commit;


insert into hm_persona ( pers_id, pers_prov, pers_nomb, pers_dire, pers_pobl, pers_codp, pers_apel, pers_telf )
values ( 2,
         'Prov. 2',
         'Nomb. 2',
         'Dire. 2',
         'Pobl. 2',
         'C.P.2',
         'Apel. 2',
         'Telf. 2' );


commit;


insert into hm_persona ( pers_id, pers_prov, pers_nomb, pers_dire, pers_pobl, pers_codp, pers_apel, pers_telf )
values ( 3,
         'Prov. 3',
         'Nomb. 3',
         'Dire. 3',
         'Pobl. 3',
         'C.P.3',
         'Apel. 3',
         'Telf. 3' );


commit;


insert into hm_persona ( pers_id, pers_prov, pers_nomb, pers_dire, pers_pobl, pers_codp, pers_apel, pers_telf )
values ( 4,
         'Prov. 4',
         'Nomb. 4',
         'Dire. 4',
         'Pobl. 4',
         'C.P.4',
         'Apel. 4',
         'Telf. 4' );


commit;


insert into hm_persona ( pers_id, pers_prov, pers_nomb, pers_dire, pers_pobl, pers_codp, pers_apel, pers_telf )
values ( 5,
         'Prov. 5',
         'Nomb. 5',
         'Dire. 5',
         'Pobl. 5',
         'C.P.5',
         'Apel. 5',
         'Telf. 5' );


commit;


insert into hm_usuario ( user_id, user_facc, user_freg, user_emai, user_rol, pers_id, user_pass, user_esta, user_user )
values ( 1,
         null, sysdate, 'user1@email.com',
                        'A',
                        1,
                        'admin',
                        'A',
                        'admin' );


commit;


insert into hm_usuario ( user_id, user_facc, user_freg, user_emai, user_rol, pers_id, user_pass, user_esta, user_user )
values ( 2,
         null, sysdate, 'user2@email.com',
                        'C',
                        1,
                        '11111',
                        'A',
                        'clie1' );


commit;


insert into hm_usuario ( user_id, user_facc, user_freg, user_emai, user_rol, pers_id, user_pass, user_esta, user_user )
values ( 3,
         null, sysdate, 'user3@email.com',
                        'C',
                        2,
                        '22222',
                        'A',
                        'clie2' );


commit;


insert into hm_usuario ( user_id, user_facc, user_freg, user_emai, user_rol, pers_id, user_pass, user_esta, user_user )
values ( 4,
         null, sysdate, 'user4@email.com',
                        'C',
                        5,
                        '33333',
                        'A',
                        'clie3' );


commit;


insert into hm_reserva ( rese_id, habi_id, clie_id, rese_esta, empl_id, rese_tota, rese_fini, rese_ffin )
values ( 1,
         2,
         3,
         'R',
         null,
         20,
         '27/10/16',
         '29/10/16' );


commit;


insert into hm_reserva ( rese_id, habi_id, clie_id, rese_esta, empl_id, rese_tota, rese_fini, rese_ffin )
values ( 2,
         2,
         4,
         'P',
         1,
         20,
         '27/10/16',
         '28/10/16' );


commit;

