create or replace package assert_utl as
    assertion_failed constant number := -20999;
    
    procedure assert_equals(message in varchar2, expected in varchar2, actual in varchar2);
    procedure assert_equals(message in varchar2, expected in number, actual in number);
    
    procedure assert_true(message in varchar2, condition in boolean);
    procedure assert_false(message in varchar2, condition in boolean);

    procedure assert_null(message in varchar2, actual in varchar2);
    procedure assert_null(message in varchar2, actual in number);
end assert_utl;
/

create or replace package body assert_utl as
    procedure assert_equals(message in varchar2, expected in varchar2, actual in varchar2) is
    begin
        if (actual != expected) then
            raise_application_error(assertion_failed, message || '. Expected: ' || expected || ', got: ' || actual);
        end if;
    end;
    procedure assert_equals(message in varchar2, expected in number, actual in number) is
    begin
        if (actual != expected) then
            raise_application_error(assertion_failed, message || '. Expected: ' || expected || ', got: ' || actual);
        end if;
    end;
    procedure assert_true(message in varchar2, condition in boolean) is
    begin
        if (not condition) then
            raise_application_error(assertion_failed, message || '. Expected: TRUE, got: FALSE');
        end if;
    end;
    procedure assert_false(message in varchar2, condition in boolean) is
    begin
        if (condition) then
            raise_application_error(assertion_failed, message || '. Expected: FALSE, got: TRUE');
        end if;
    end;
    procedure assert_null(message in varchar2, actual in varchar2) is
    begin
        if (actual is not null) then
            raise_application_error(assertion_failed, message || '. Expected: NULL, got: ' || actual);
        end if;
    end;
    procedure assert_null(message in varchar2, actual in number) is
    begin
        if (actual is not null) then
            raise_application_error(assertion_failed, message || '. Expected: NULL, got: ' || actual);
        end if;
    end;
end assert_utl;
/