-- 계정 등록
-- INSERT INTO tbl_menu (menu_cd, menu_cd_name, upper_cd, cost)
VALUES ('DRINK', '음료', 'TOP', NULL),
       ('DESSERT', '디저트', 'TOP', NULL),

--  음료
       ('AMERICANO', '아메리카노', 'DRINK', 4000),
       ('ESPRESSO', '에스프레소', 'DRINK', 3500),
       ('CAFE_LATTE', '카페라떼', 'DRINK', 4500),
       ('CAPPUCCINO', '카푸치노', 'DRINK', 4500),
       ('CHOCO', '퐁당초콜렛', 'DRINK', 5000),
       ('STRAWBERRY_LATTE', '딸기라떼', 'DRINK', 5500),
       ('GRAPEFRUIT_ADE', '자몽에이드', 'DRINK', 5000),
       ('PEPPERMINT_TEA', '페퍼민트 차', 'DRINK', 5000),
       ('CHAMOMILE_TEA', '카모마일 차', 'DRINK', 5000),
       ('EARL_GRAY_TEA', '얼그레이 차', 'DRINK', 5000),
       ('ASSAM_TEA', '아쌈 차', 'DRINK', 5000),
       ('DARJEELING_TEA', '다즐링 차', 'DRINK', 5000),
--  디저트
       ('YOGURT_ROLL', '요거트롤', 'DESSERT', 3500),
       ('BANHANA_PUDDING', '반하나 푸딩', 'DESSERT', 6000),
       ('POLLACK_ROE', '명란 바게트', 'DESSERT', 3800),
       ('PANTALOON_CHIVE', '판다롱 부추빵', 'DESSERT', 2000),
       ('YAKISOBA_BREAD', '야끼소바 빵', 'DESSERT', 4000),
       ('SMALL_ECHO', '작은 메아리', 'DESSERT', 3000),
       ('TIRAMISU', '티라미수', 'DESSERT', 5500),

--  옵션
       ('HOT_OPT', 'HOT', 'OPTION', null),
       ('ICE_OPT', 'ICE', 'OPTION', null),
       ('LIGHT', '연하게', 'OPTION', null),
       ('THICK', '진하게', 'OPTION', null);

