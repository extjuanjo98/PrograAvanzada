with Text_IO;

procedure Main is
   type semana is (lunes,martes,miercoles,jueves,viernes,sabado,domingo);
   subtype laboral is semana range lunes..viernes;
   dia:semana;
   dia2:laboral;



begin
   dia:=sabado;--bien
   dia2:=martes;--bien
   dia:=juernes;--error porque no esta en la enumeracion
   dia2:=sabado;--warning porque no entra en el rango
   --por lo tanto todo esta bien
end Main;
