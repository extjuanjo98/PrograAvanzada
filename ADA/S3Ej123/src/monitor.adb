package body Monitor is
   protected body Moni is
      procedure incrementa is
      begin
         contador:= contador +1;
      end incrementa;
      function read return Integer is
      begin
         return contador;
      end read;

      procedure write(valor:Integer) is
      begin
         contador:=valor;
      end write;

   end Moni;
end Monitor;
