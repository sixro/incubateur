create or replace package my_package_tests as
    procedure from_my_code_to_bool_returns_Y;
    procedure from_my_code_to_bool_returns_N;
    procedure two_numbers_are_equals;
    procedure assert_true_test;
    procedure assert_null_test;
end my_package_tests;
/

create or replace package body my_package_tests as
    procedure from_my_code_to_bool_returns_Y is
    begin
        assert_utl.assert_equals('wrong translation from my code to bool', 'Y', my_package.from_my_code_to_bool('AA'));
    end;
    procedure from_my_code_to_bool_returns_N is
    begin
        assert_utl.assert_equals('from_my_code_to_bool', 'N', my_package.from_my_code_to_bool('AA'));
    end;
    procedure two_numbers_are_equals is
        my_number number;
    begin
        -- NOTE: this is a dummy test!
        my_number := 2;
        assert_utl.assert_equals('2 = 3', 3, my_number);
    end;
    procedure assert_true_test is
        my_number number;
    begin
        my_number := 2;
        assert_utl.assert_true('hello', my_number = 3);
    end;
    procedure assert_null_test is
        my_text varchar2(100);
    begin
        my_text := 'x';
        assert_utl.assert_null('not null', my_text);
    end;
end my_package_tests;
/

call my_package_tests.from_my_code_to_bool_returns_y();
call my_package_tests.from_my_code_to_bool_returns_n();
call my_package_tests.two_numbers_are_equals();
call my_package_tests.assert_true_test();
call my_package_tests.assert_null_test();
