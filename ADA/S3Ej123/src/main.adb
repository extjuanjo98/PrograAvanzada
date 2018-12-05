with Text_IO;
with monitor;
use monitor;

procedure Main is
   task type Tarea;
   incremento:Integer:=0;
   monitor:Moni;
   package Integer_IO is new Text_IO.Integer_IO(Integer);

task body Tarea is
begin
      for i in 1..10 loop
         monitor.incrementa;
         Integer_IO.Put(monitor.read);
         Text_IO.Put_Line(" ");
      end loop;
end Tarea;


procedure ejecutarTareas is
  proceso:Tarea;
begin
  null;
end ejecutarTareas;

begin
   monitor.write(0);
   for i in 1..20 loop
      ejecutarTareas;
   end loop;
   --Integer_IO.Put(incremento);
   null;
end Main;
