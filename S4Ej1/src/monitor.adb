with Ada.Text_IO;
with Text_IO;

package body Monitor is
   package Integer_IO is new Text_IO.Integer_IO(Integer);

   protected body TGestor is

      entry iniciarLectura
        when not escribiendo and (turnoLectura or iniciarEscritura'Count=0) is
      begin
         if iniciarEscritura'Count=0 then
            turnoLectura:=True;
         end if;

         nLectores:=nLectores + 1;
         Text_IO.Put_Line("Leyendo");
      end iniciarLectura;

      procedure terminarLectura is
      begin
         turnoLectura:=False;
         Text_IO.Put("Terminando lectura, somos ");
         Integer_IO.Put(nLectores);
         Text_IO.Put_Line("");
         nLectores:=nLectores-1;
      end terminarLectura;

      entry iniciarEscritura
        when not escribiendo and nLectores=0 is
      begin
         escribiendo:=True;
         Text_IO.Put_Line("escribiendo...");
      end iniciarEscritura;

      procedure terminarEscritura is
      begin
         Text_IO.Put_Line("Terminando escritura...");
         turnoLectura:=True;
         escribiendo:=False;
      end terminarEscritura;

   end TGestor;
end Monitor;
