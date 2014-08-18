create or replace package sql_unit as
    procedure run(p_package_name in varchar2);
end sql_unit;
/

create or replace package body sql_unit as
    procedure run(p_package_name in varchar2) is
        cursor all_procs_in_pkg  is select p.procedure_name
            from all_procedures p 
                inner join all_arguments args on (lower(args.package_name) = lower(p.object_name) AND lower(args.object_name) = lower(p.procedure_name))
            where lower(p.object_name) = p_package_name
              and p.object_type = 'PACKAGE'
              and (args.in_out = 'IN' and args.argument_name is null and args.data_type is null)
            order by p.subprogram_id;
        v_call varchar2(250);
    begin
        --select * from all_objects where object_type = 'PACKAGE' and lower(object_name) = lower(package_name);
        --select distinct object_type from all_objects
        --select * from all_objects where lower(object_name) = lower('from_my_code_to_bool_returns_Y')

        for v_rec in all_procs_in_pkg loop
            begin
                v_call := 'call ' || p_package_name || '.' || v_rec.procedure_name || '()';
                execute immediate v_call;
            exception
                when others then 
                    dbms_output.put_line('test: ' || v_call);
                    dbms_output.put_line(sqlcode || ' - ' || substr(sqlerrm(sqlcode), 1, 400));
                    continue;
            end;
        end loop;
    end;
end sql_unit;
/