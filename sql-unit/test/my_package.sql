create or replace package my_package as
    function from_my_code_to_bool(a_field varchar2) return varchar2;
end my_package;
/

create or replace package body my_package as
    function from_my_code_to_bool(a_field varchar2) return varchar2 is
        ret varchar2(1);
    begin
        if (length(a_field) > 2) then
            ret := 'Y';
        else
            ret := 'N';
        end if;
        return(ret);
    end;
end my_package;
/
