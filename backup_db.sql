PGDMP     9                     z            design_patterns    14.2    14.2 A    F           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            G           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            H           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            I           1262    16398    design_patterns    DATABASE     Z   CREATE DATABASE design_patterns WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'C';
    DROP DATABASE design_patterns;
                postgres    false            �            1259    16521    c_id    SEQUENCE     m   CREATE SEQUENCE public.c_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
    DROP SEQUENCE public.c_id;
       public          postgres    false            �            1259    16470    cinema    TABLE     5  CREATE TABLE public.cinema (
    cinema_id bigint NOT NULL,
    cinema_name character varying(100),
    address character varying(100),
    phone character varying(100),
    info text,
    start_of_work character varying(100),
    end_of_work character varying(100),
    image_file character varying(2000)
);
    DROP TABLE public.cinema;
       public         heap    postgres    false            �            1259    16469    cinema_cinema_id_seq    SEQUENCE     }   CREATE SEQUENCE public.cinema_cinema_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.cinema_cinema_id_seq;
       public          postgres    false    219            J           0    0    cinema_cinema_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.cinema_cinema_id_seq OWNED BY public.cinema.cinema_id;
          public          postgres    false    218            �            1259    16479    cinema_hall    TABLE     �   CREATE TABLE public.cinema_hall (
    cinema_hall_id bigint NOT NULL,
    hall_name character varying(50),
    number_of_rows integer,
    number_of_cols integer,
    cinema_id integer
);
    DROP TABLE public.cinema_hall;
       public         heap    postgres    false            �            1259    16478    cinema_hall_cinema_hall_id_seq    SEQUENCE     �   CREATE SEQUENCE public.cinema_hall_cinema_hall_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.cinema_hall_cinema_hall_id_seq;
       public          postgres    false    221            K           0    0    cinema_hall_cinema_hall_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.cinema_hall_cinema_hall_id_seq OWNED BY public.cinema_hall.cinema_hall_id;
          public          postgres    false    220            �            1259    16434    detail    TABLE     @  CREATE TABLE public.detail (
    detail_id bigint NOT NULL,
    country character varying(100),
    language character varying(100),
    duration integer,
    release_date date,
    age_rating character varying(10),
    rating double precision,
    number_of_votes integer,
    description text,
    movie_id integer
);
    DROP TABLE public.detail;
       public         heap    postgres    false            �            1259    16433    detail_detail_id_seq    SEQUENCE     }   CREATE SEQUENCE public.detail_detail_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.detail_detail_id_seq;
       public          postgres    false    212            L           0    0    detail_detail_id_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.detail_detail_id_seq OWNED BY public.detail.detail_id;
          public          postgres    false    211            �            1259    16460    genre    TABLE     b   CREATE TABLE public.genre (
    genre_id bigint NOT NULL,
    genre_type character varying(50)
);
    DROP TABLE public.genre;
       public         heap    postgres    false            �            1259    16459    genre_genre_id_seq    SEQUENCE     {   CREATE SEQUENCE public.genre_genre_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.genre_genre_id_seq;
       public          postgres    false    216            M           0    0    genre_genre_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.genre_genre_id_seq OWNED BY public.genre.genre_id;
          public          postgres    false    215            �            1259    16425    movie    TABLE     �   CREATE TABLE public.movie (
    movie_id bigint NOT NULL,
    movie_name character varying(150),
    original_name character varying(150),
    image_file character varying(2000)
);
    DROP TABLE public.movie;
       public         heap    postgres    false            �            1259    16466    movie_genre    TABLE     P   CREATE TABLE public.movie_genre (
    movie_id integer,
    genre_id integer
);
    DROP TABLE public.movie_genre;
       public         heap    postgres    false            �            1259    16424    movie_movie_id_seq    SEQUENCE     {   CREATE SEQUENCE public.movie_movie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.movie_movie_id_seq;
       public          postgres    false    210            N           0    0    movie_movie_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.movie_movie_id_seq OWNED BY public.movie.movie_id;
          public          postgres    false    209            �            1259    16448    role_detail    TABLE     �   CREATE TABLE public.role_detail (
    role_id bigint NOT NULL,
    role_name character varying(100),
    role_surname character varying(100),
    role_type character varying(20),
    detail_id integer
);
    DROP TABLE public.role_detail;
       public         heap    postgres    false            �            1259    16447    role_detail_role_id_seq    SEQUENCE     �   CREATE SEQUENCE public.role_detail_role_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.role_detail_role_id_seq;
       public          postgres    false    214            O           0    0    role_detail_role_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.role_detail_role_id_seq OWNED BY public.role_detail.role_id;
          public          postgres    false    213            �            1259    16491    schedule    TABLE     �   CREATE TABLE public.schedule (
    schedule_id bigint NOT NULL,
    schedule_date date,
    start_time character varying(10),
    cinema_hall_id integer,
    movie_id integer
);
    DROP TABLE public.schedule;
       public         heap    postgres    false            �            1259    16490    schedule_schedule_id_seq    SEQUENCE     �   CREATE SEQUENCE public.schedule_schedule_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.schedule_schedule_id_seq;
       public          postgres    false    223            P           0    0    schedule_schedule_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.schedule_schedule_id_seq OWNED BY public.schedule.schedule_id;
          public          postgres    false    222            �            1259    16507    ticket_type    TABLE     �   CREATE TABLE public.ticket_type (
    adult_ticket integer,
    child_ticket integer,
    student_ticket integer,
    schedule_id integer
);
    DROP TABLE public.ticket_type;
       public         heap    postgres    false            �           2604    16473    cinema cinema_id    DEFAULT     t   ALTER TABLE ONLY public.cinema ALTER COLUMN cinema_id SET DEFAULT nextval('public.cinema_cinema_id_seq'::regclass);
 ?   ALTER TABLE public.cinema ALTER COLUMN cinema_id DROP DEFAULT;
       public          postgres    false    219    218    219            �           2604    16482    cinema_hall cinema_hall_id    DEFAULT     �   ALTER TABLE ONLY public.cinema_hall ALTER COLUMN cinema_hall_id SET DEFAULT nextval('public.cinema_hall_cinema_hall_id_seq'::regclass);
 I   ALTER TABLE public.cinema_hall ALTER COLUMN cinema_hall_id DROP DEFAULT;
       public          postgres    false    221    220    221            �           2604    16437    detail detail_id    DEFAULT     t   ALTER TABLE ONLY public.detail ALTER COLUMN detail_id SET DEFAULT nextval('public.detail_detail_id_seq'::regclass);
 ?   ALTER TABLE public.detail ALTER COLUMN detail_id DROP DEFAULT;
       public          postgres    false    211    212    212            �           2604    16463    genre genre_id    DEFAULT     p   ALTER TABLE ONLY public.genre ALTER COLUMN genre_id SET DEFAULT nextval('public.genre_genre_id_seq'::regclass);
 =   ALTER TABLE public.genre ALTER COLUMN genre_id DROP DEFAULT;
       public          postgres    false    216    215    216            �           2604    16428    movie movie_id    DEFAULT     p   ALTER TABLE ONLY public.movie ALTER COLUMN movie_id SET DEFAULT nextval('public.movie_movie_id_seq'::regclass);
 =   ALTER TABLE public.movie ALTER COLUMN movie_id DROP DEFAULT;
       public          postgres    false    210    209    210            �           2604    16451    role_detail role_id    DEFAULT     z   ALTER TABLE ONLY public.role_detail ALTER COLUMN role_id SET DEFAULT nextval('public.role_detail_role_id_seq'::regclass);
 B   ALTER TABLE public.role_detail ALTER COLUMN role_id DROP DEFAULT;
       public          postgres    false    213    214    214            �           2604    16494    schedule schedule_id    DEFAULT     |   ALTER TABLE ONLY public.schedule ALTER COLUMN schedule_id SET DEFAULT nextval('public.schedule_schedule_id_seq'::regclass);
 C   ALTER TABLE public.schedule ALTER COLUMN schedule_id DROP DEFAULT;
       public          postgres    false    223    222    223            =          0    16470    cinema 
   TABLE DATA           v   COPY public.cinema (cinema_id, cinema_name, address, phone, info, start_of_work, end_of_work, image_file) FROM stdin;
    public          postgres    false    219   �I       ?          0    16479    cinema_hall 
   TABLE DATA           k   COPY public.cinema_hall (cinema_hall_id, hall_name, number_of_rows, number_of_cols, cinema_id) FROM stdin;
    public          postgres    false    221   (K       6          0    16434    detail 
   TABLE DATA           �   COPY public.detail (detail_id, country, language, duration, release_date, age_rating, rating, number_of_votes, description, movie_id) FROM stdin;
    public          postgres    false    212   &L       :          0    16460    genre 
   TABLE DATA           5   COPY public.genre (genre_id, genre_type) FROM stdin;
    public          postgres    false    216   
Y       4          0    16425    movie 
   TABLE DATA           P   COPY public.movie (movie_id, movie_name, original_name, image_file) FROM stdin;
    public          postgres    false    210   �Y       ;          0    16466    movie_genre 
   TABLE DATA           9   COPY public.movie_genre (movie_id, genre_id) FROM stdin;
    public          postgres    false    217   y[       8          0    16448    role_detail 
   TABLE DATA           ]   COPY public.role_detail (role_id, role_name, role_surname, role_type, detail_id) FROM stdin;
    public          postgres    false    214   \       A          0    16491    schedule 
   TABLE DATA           d   COPY public.schedule (schedule_id, schedule_date, start_time, cinema_hall_id, movie_id) FROM stdin;
    public          postgres    false    223   �c       B          0    16507    ticket_type 
   TABLE DATA           ^   COPY public.ticket_type (adult_ticket, child_ticket, student_ticket, schedule_id) FROM stdin;
    public          postgres    false    224   �e       Q           0    0    c_id    SEQUENCE SET     3   SELECT pg_catalog.setval('public.c_id', 70, true);
          public          postgres    false    225            R           0    0    cinema_cinema_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.cinema_cinema_id_seq', 4, true);
          public          postgres    false    218            S           0    0    cinema_hall_cinema_hall_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.cinema_hall_cinema_hall_id_seq', 30, true);
          public          postgres    false    220            T           0    0    detail_detail_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.detail_detail_id_seq', 18, true);
          public          postgres    false    211            U           0    0    genre_genre_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.genre_genre_id_seq', 21, true);
          public          postgres    false    215            V           0    0    movie_movie_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.movie_movie_id_seq', 18, true);
          public          postgres    false    209            W           0    0    role_detail_role_id_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.role_detail_role_id_seq', 1, false);
          public          postgres    false    213            X           0    0    schedule_schedule_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.schedule_schedule_id_seq', 70, true);
          public          postgres    false    222            �           2606    16484    cinema_hall cinema_hall_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.cinema_hall
    ADD CONSTRAINT cinema_hall_pkey PRIMARY KEY (cinema_hall_id);
 F   ALTER TABLE ONLY public.cinema_hall DROP CONSTRAINT cinema_hall_pkey;
       public            postgres    false    221            �           2606    16477    cinema cinema_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.cinema
    ADD CONSTRAINT cinema_pkey PRIMARY KEY (cinema_id);
 <   ALTER TABLE ONLY public.cinema DROP CONSTRAINT cinema_pkey;
       public            postgres    false    219            �           2606    16441    detail detail_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY public.detail
    ADD CONSTRAINT detail_pkey PRIMARY KEY (detail_id);
 <   ALTER TABLE ONLY public.detail DROP CONSTRAINT detail_pkey;
       public            postgres    false    212            �           2606    16465    genre genre_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.genre
    ADD CONSTRAINT genre_pkey PRIMARY KEY (genre_id);
 :   ALTER TABLE ONLY public.genre DROP CONSTRAINT genre_pkey;
       public            postgres    false    216            �           2606    16432    movie movie_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.movie
    ADD CONSTRAINT movie_pkey PRIMARY KEY (movie_id);
 :   ALTER TABLE ONLY public.movie DROP CONSTRAINT movie_pkey;
       public            postgres    false    210            �           2606    16453    role_detail role_detail_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.role_detail
    ADD CONSTRAINT role_detail_pkey PRIMARY KEY (role_id);
 F   ALTER TABLE ONLY public.role_detail DROP CONSTRAINT role_detail_pkey;
       public            postgres    false    214            �           2606    16496    schedule schedule_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT schedule_pkey PRIMARY KEY (schedule_id);
 @   ALTER TABLE ONLY public.schedule DROP CONSTRAINT schedule_pkey;
       public            postgres    false    223            �           2606    16502    schedule fk_cinema_hall_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT fk_cinema_hall_id FOREIGN KEY (cinema_hall_id) REFERENCES public.cinema_hall(cinema_hall_id);
 D   ALTER TABLE ONLY public.schedule DROP CONSTRAINT fk_cinema_hall_id;
       public          postgres    false    3487    221    223            �           2606    16485    cinema_hall fk_cinema_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.cinema_hall
    ADD CONSTRAINT fk_cinema_id FOREIGN KEY (cinema_id) REFERENCES public.cinema(cinema_id);
 B   ALTER TABLE ONLY public.cinema_hall DROP CONSTRAINT fk_cinema_id;
       public          postgres    false    221    3485    219            �           2606    16454    role_detail fk_detail_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.role_detail
    ADD CONSTRAINT fk_detail_id FOREIGN KEY (detail_id) REFERENCES public.detail(detail_id);
 B   ALTER TABLE ONLY public.role_detail DROP CONSTRAINT fk_detail_id;
       public          postgres    false    212    214    3479            �           2606    16442    detail fk_movie    FK CONSTRAINT     u   ALTER TABLE ONLY public.detail
    ADD CONSTRAINT fk_movie FOREIGN KEY (movie_id) REFERENCES public.movie(movie_id);
 9   ALTER TABLE ONLY public.detail DROP CONSTRAINT fk_movie;
       public          postgres    false    212    3477    210            �           2606    16497    schedule fk_movie_id    FK CONSTRAINT     z   ALTER TABLE ONLY public.schedule
    ADD CONSTRAINT fk_movie_id FOREIGN KEY (movie_id) REFERENCES public.movie(movie_id);
 >   ALTER TABLE ONLY public.schedule DROP CONSTRAINT fk_movie_id;
       public          postgres    false    223    3477    210            �           2606    16510    ticket_type fk_schedule_id    FK CONSTRAINT     �   ALTER TABLE ONLY public.ticket_type
    ADD CONSTRAINT fk_schedule_id FOREIGN KEY (schedule_id) REFERENCES public.schedule(schedule_id);
 D   ALTER TABLE ONLY public.ticket_type DROP CONSTRAINT fk_schedule_id;
       public          postgres    false    224    3489    223            =   W  x�͒�K�0���_��i�vk��-nSD'�Dv��f64MF���7�Cd�m�rH���_̦�Ȋ>3۸�Ľ�Obfu�A��6L�\�,�#U�C �� �/��95�,m�)�z��+2i������g'		O���#��0��`��GQ�J[7����!�P��ȶ�\�4��xR�XS�7�̿�J��j�ס�V"��[�!����z�t>bq�]�h{/�z�MZk�`1���'�+#����R*�l	��G�$���P(�7�!�c�������?p�Sv�y�r0o<Oj��x�4�$�3�4���R�J_ł��O�'�B�U�t������c^����}O�=      ?   �   x�]���0Eg�+��N�׈� L,,E��
��-A�r���\�`;��#�"z�>%AA �Qs�,k5Oe�hl��q����j����{�=Dh82S�J�"sT'�4[����4���KQ�i"�*��գ�]]ܜ��	��a͸�Лuƍ�36w�^�)	W­��<��ǭ���+���q����5������y��-��Cxd5�R�L�x������>y^!�c=��      6   �  x��Y˒�]�_���ϰ���7�QlɎ-�)�f6`7�0@7)j����Kr�HΌ�VT*��l�yι�����=L�_M�W���bq~qu~q;��}3��]���䇭q{�V���tU��TT�ՙ.Dkҙ�z<��}�����������ϨШ��G�������c�0M�53�kة��*핳[��Ðp�<�W�ܺ�m~�Q��׿�V�����u��#܁Ѫӱ��)�H=�Pac�V��j9�l�ǃ����۫��~?S��^i���������e�6�o`����So�������	ݫ�������A5v�����>�A�}���N��^��t�,�a4������ۜΐ�Q2g��I$���&�&��%s���7���Y\�*g>��fr7�O��ɏzk�J%��ΰ(��h�q5�{��T�d�mb���^X��t,�X�(ɷV�Fè0S���o8�7��u�q>��6�؀�w������ˡ���CՇ�����v��l\�{ڭY�3��e�5���G�$e�G�~�C�v��zV����f��X���MN��86��P_�>S����*�^zϡ�}�3p��c1�i�#�,ܰ��tݬĲ7�Kj؜Rڄ���꽶.�mD�G�cJ�v!�ZJ���bZ
Ơb{4r����E��e�&����g�I��ԣ*֟P'8Y�'sT�=���j�V��f!;��0��"R;Tm��vx��t�7��6pm`N���ֺ��>�$�ث���ek\(���P#̬3��*��X�h��[�~����mmx��Ѣ��#�q�1�K�,�-|��v(���F���G�k�͎�f�@�q�����5��`��?�V�7n�nr9��,]�g�Z������bު$y���8S�X3 �4"�P[����n�V�j��t�GYo�1�'F�D��!W_'�m��蔳��<��(l�?K�t�cw i�=��Ks��兺@��ԧ�N;�mf�5:�`��	�~��Ч� �|��S�a��h��s6��
^�.���~*��
��;d=���q��'�4���#sy���rp;�\M������J��vv?�__��G\a��h*7��~&��V��H��C��fp�C��u�� �ǯ�s���F��S���B����2n>BaT,������U(>���t��Й�bJ&?�b��ԞI�Zb�2�VXe��4��jQ�Ʃ�������}"��$�)���
;v��*8ώ��k[{��� ���<��RK�#x8#k4פ|����a�CwpJ<@��YY��R�+˳+�&��B{�p�a=�P�
��'&Os&yj:�*	b����b���	��7(91���2X�|i	�ף��U�!a�Rt��+fu؀hel����3��S=�*�#Z�1��3_�؎^�Hai�����co�~~�����H�sf>d�	5�Ř���M��7'aq�T��澙\_�O�Buh����vH"���gih#U-ن�ҼЁr!��f�/�8þ}m���Dv(*FאŹ�
�	�A�D����6ޠu!�&C��WS�_(��6wbI\v�����C���h�z���*�%�qXIƍ�[�OT�����],
��pQBY�D�Z�cf$ О����jS��\4�x
���H�Y7��Si\޼���0^N�a�,j_�	�}��^����u�eF�x9��T6�;9�7?�CnG���X/��W�<?ޑq���^�3UUny"XL'2N�+�%��~=~_رKΞ=u�V�:1D)C�p��5Ţt��S���Š;p�f�hE�4��Y���Y�V�<�hy�,mP��B���N�4���}{�k仪yi|�ʹ��&Q���kcRNb��=R���U!�V�h ��\������}�YfE�!�Iŀʼ�޿P���/g�����Ʉ`��8zLO�%E3�4:	Oҟq�� � ���COFݱ�ؖ��Q�-���w��˃u�̋�;1/�TDT�:#fW1�a�q�܉Tb�si��Q�z����[���5���0$�ƜW�Ck��y��gE���\�vY#r��i5 ���h��olCޛך��J ���?Z���<t��Lk=ШͶ�l!�en��+�1/����=�����Y'��J��P�@$	�pzO�!�m�V �B������d��ɶ�yTB�Q�9�+͡���bI� _����#-ܖem����8��%T�jا��HSZ�((�	���Q���D����"j�ʎ�3b�r[2'�n��	�Gg����
��C��@��T�l6��l�w��|�rԜH�A7�L�_:>������Cm��w��'bI���o��_?�QВ!U��Ѐ�d��Js�/�ހ����5Ԙ��d��n���_�5��i<�l���?�[H(]�J��ʔ��:Y�2�֯���N�J���.%���Wz�	]�t4?QB�Y�
Ŧ���5�/N��x���!u���~8�<�W��OPNT{ٷ�+�c�r�&j��B��&��(%���e�,#���@�>Z�	�ٺיf:�u��j,�V��#0k.�k-�f�~���a>*�.c�cF�Pp�{��������X�}�r�,_�=��>�K����	� ���B�g@G'��\��ϼ�U	�����5��B�4��ɠ���|9��8�����;D��������M��ט�U>�J�わwr{�rJ�(>ND��|�0��H|}�w�:�=p��|)�~��Q���%���E�����h�!�p/њk��3��@���t~���Oc�����i�'���e��B��<X�i-�MVpe}[�Sj�i�å�%��H���XAj(�ƣ�WG�����Ye�k���Z��cW+Ƚ��:�PG�]q�ar��3.\d���lB�+��7%2�x�� jӘ�͂�v�2B+ y�l7���)��_]�=K��牥MH)�Q~I�Q�;v�# �Qz-�|t�D>����G�&/K�{�� t��Wf�	��'G�@L��($<�I-�+�uv����_�[��LD�����坢2��L�ۡ+��|o����]���U��������P�e$ ��L��Үd�.�{��7)�S�Z!�VCg
_���,��QD!lh��t~7yk>�*�IwwGܺ����8,��uC	��U�q4B��~�Ί/�6�d^�W-3w��Z��Y=�pц��]��<P>$(�7$	�0��d)�`]�����q6�N�ĊI�      :   �   x�M�;n�0D��)�L�+��.i��	H��z�ۇHR�{3�����-4����d�nAGd�2ntBv�Bg�Ε邉��m�+&�]qC�*K�ݟ��m�WJ{��nN)�Ϯ�H� ��1@���>��U���(�"�j�v�V}Ƨڗ�}�(]�����t��5ZnxJ����O�8�Tfm�\3�x'�o�_O�      4   �  x��Q�N1>O�b� u!�7�*�n�z�b�a�Үy�T{C q����A����+̾cW�T.�|�|����cr�/��1��
r�iYb�q�L�?��*�����.Ms*l��"_�ʩ��fZ��w'<�����$�}wt}7UE�&�����Ny�/�σt���w[{�Ѿ}�D��Yw���5z��)U��k$�-iC8hʒ|�$�g�g�J�?�.���'_b끚ⷦ��A�'0RΫ��
�*��[�c��	���eM鵘^Sp SSC���	1��k��P��-5-���CF�u���uH�\�;ހ}]�ҡ�Ly��X�ײ�{~�.Q67�N>�",�o��M؛�S^[��w+R�].��d:G����(�k�i"�<ᔰh�X{�<X��z�^���      ;   �   x�%��C!ϸ��6��K��#+rТ�i(4T�F�p����A���"�F:Q�E)�F��M������8�g,��m�$/���4�X��$��|��=�\����Jw�]y����/���w����������v%�v|?��%'      8   �  x�}X�r9<�_�۞f���ɡ�%�z�kj����T�A6L4�E�4O��{�%�դh��)������^����K[Z{�İ7��T�'��Ϋ����V�o�d�mx"V^�2%����g������3�YS��J��mx.nȹZ�
*��ݯ-�g!w�OT)-_��j��83y-��4�B����V+C.~=�K2��r��kx�a%�X�e��x,Υa셜?�f���)w ��(F��R���7�%l#���`��جL��U���[`!Վ�*�{/]�/�y�
߬/^p�-6�EY������J񕴎K�F�Na��Y��qL����/˶| ���j��?�*�|2��!��!1� 3q��0$nC.w��"4�l�L&w�TP8�.���_'Ε&�8zm�#�
%��ɤc��U�$ϩv�S%��{�`�@&Զ$�N<�G\�Nm��0ԥ���D��e�Q-t�����E�V3;�)�h�Y=��N�4%�3�"�&q����i�7���h.�#�PFd�Z��(_k��Ȉ-q�����?O� 6����E'�Z������!��{��EUY��8w�����c溴&,mx"[R��q��~�lәl*n��>3*#��8#�/T����p�D�3N�����Yo�ld�@ʭ$߮:�M�rd�*�/b�/�S$���A��?r�c�X;YIq��*��̡��&MLh:��s�Ua}rS�͠\0]� `Ǚ���������3�X핱EN�.����� SP���7�ߩ���,�P�L�ӧ���ʚ�-���������X\��yq��F��Gl��Y˰F:����W��$��>H堘�֘H�9'�$d��/�K�X�ڢ����;�b@"C��|�z�1�H�[^����X����T�+��8�'�|�k�
�
���`薐pG�`q����1YnzbG��.I��h��N�K����8������ವ���X�X��C2�b���*�]Żh�2���{2��Y��Y�#����}�X���rT�F��X|1[H�e`�k��g�7�p$�$��ЙeqTa43�@f�f�j����,#0烥]Q��c\�Zwօ���h�}��&Yq�P�i/��Y�w8$#έC[JST�m]�%R���@�#��ĕ_���(��"��8�����2����k'��q@�R��	��5���I�
c3�[m��V��a1.���;x�l�n����|�`�#s���{�%�׭��K;Eq�f�"4�ԁ@n��W�֥��-\�P�'�m
���8�^���*a�\X7�j�Ż�`0�J�!Ve{Md��N����z�����RB�¹�@aE�\4���2�@��r=����0�kN�?�|U�q��ck{�m�5�Yk�������6и�lla(M��:��mug9H�E#)��؅�)6ߥ3H����I�i�'˚�0#Sl	Ř4�O�^���-27z��yKYu���F��xp�a�N��+���x���8t�P��2�i���٠�>N��M�9}��̿�-�	Ϛe�d�:����F_�?�Fg�Ecv�-j��� ���;���vF�����s�%8�wX� ��%������8>�K���%��a���Ybh�.K@`=�g����a�q�d���_����N������FG-�����'��r�P��@�D˭j�=�L����Pb^�ż1e��8�,B?����A�:}q4,1����,�� l���o(?�����Y�͋��F�f���+݉h0��	�G�=W�nJ0�+&�	��{t�-��d���SlB%����|ρ�D��v!_�5�(�cg`����S�vFG�&��2ck��ˣ��+�Z���I�tm�1p�w�;��݂�����h�p|�b�0�U�\��8o�1��N�L�W�S>2��5e��;��V6��A��[mcQI�Q�/��k���|�p�      A   �  x�m�[�� D�e/w������:bLM���A�iT����GZ�vj-R��>N�a�V9y�����J��m�d�S�l�ŋPe�Yg��"6��Ud�(�xuhw\^��d.-Z�:��G�z�}o�W���4����+ޱ�;��G�1�#Ơ�GF���q#}�U}��<���!��~Y	F��H~H�!E%�E�cws���)� �}�42���<�Ng)��K:s�@�J�0+�R���;Zށ��w�zض�|���	T�'z�5FG���Np�]�����Y��D)�v����H�`�@�sc56ˏ]���AeX�E�=�t<'l�v�����-�//|��/�}iБ������=F�䋎(�� ?�fPJ���@��GtJ����/���.0v�򧤎�\o��CDg�      B   �   x�e�k� ��a6}���x�s,��11�7�e�*��`�a}ɂ��������SY�$ޞ�e�Xy���3��X��8y�3`n�xdz�C���D!bz�;b�{)��{_2}��܁�O���qe��s=�W�����A��#s%`��u�{���)z�؀����n4�و�\��&^	��QTW;����K��Gj�����h��C02pǄ���̐��+:xt��`�����=�xR�r~J)?���     