with Text_IO;

--Usare el ejercicio 3 para el numerado
procedure Main is

   type Semana is(Lunes,Martes,Miercoles,Jueves,Viernes,Sabado,Domingo);
   dia : Semana;
   package Integer_IO is new Text_IO.Integer_IO(Integer);
begin
   dia := Semana'First;
   loop
      exit when dia = Semana'Last;
      Text_IO.Put_Line(Semana'Image(dia));
      dia := Semana'Succ(dia);
   end loop;
   Text_IO.Put_Line(Semana'Image(dia));
end Main;
