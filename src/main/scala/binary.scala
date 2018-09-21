import java.io.{BufferedOutputStream, File, FileOutputStream}
object binary extends App {
  def createfile(inputtemplate: String, byte_sequence: Array[Byte], header: Array[Byte], footer: Array[Byte], result:String):Unit={
    val fullsize = new File(inputtemplate).length()
    val headersize = header.length
    val footersize = footer.length
    println("fullsize template: " + fullsize)
    println("header size:       " + headersize)
    println("footer size:       " + footersize)
    val remain = fullsize - headersize - footersize
    println("data inserted size:" + remain)
    val insertseqlen = byte_sequence.length
    println("byte_sequence size:" + insertseqlen)
    val reps = remain / insertseqlen
    println("reps:              " + reps)
    val resulted = new BufferedOutputStream(new FileOutputStream(result))
    println("starting writes")
    resulted.write(header)
    for (i <-reps to 0 by -1)
      resulted.write(byte_sequence)
    resulted.write(footer)
    resulted.close()
    println("writing to " + result + " complete!\n")
  }
  val array2byte1seq = Array[Byte](0xaa.toByte, 0xaa.toByte, 0x55.toByte, 0x55.toByte)
  val array2byte2seq = Array[Byte](0x55.toByte, 0x55.toByte, 0xaa.toByte, 0xaa.toByte)
  val array2byte3seq = Array[Byte](0xaa.toByte, 0xaa.toByte, 0x00.toByte, 0x00.toByte)
  val array2byte4seq = Array[Byte](0x00.toByte, 0x00.toByte, 0xaa.toByte, 0xaa.toByte)
  val array2byte5seq = Array[Byte](0xdb.toByte, 0xdb.toByte, 0x24.toByte, 0x24.toByte)
  val array2byte6seq = Array[Byte](0x24.toByte, 0x24.toByte, 0xdb.toByte, 0xdb.toByte)
  val array3byte1seq = Array[Byte](0xaa.toByte, 0xaa.toByte, 0xaa.toByte, 0x55.toByte, 0x55.toByte, 0x55.toByte)
  val array3byte2seq = Array[Byte](0x55.toByte, 0x55.toByte, 0x55.toByte, 0xaa.toByte, 0xaa.toByte, 0xaa.toByte)
  val array3byte3seq = Array[Byte](0x55.toByte, 0x55.toByte, 0x00.toByte, 0xaa.toByte, 0xaa.toByte, 0x00.toByte)
  val array3byte4seq = Array[Byte](0xaa.toByte, 0xaa.toByte, 0xaa.toByte, 0x00.toByte, 0x00.toByte, 0x00.toByte)
  val array3byte5seq = Array[Byte](0x00.toByte, 0x00.toByte, 0x00.toByte, 0xaa.toByte, 0xaa.toByte, 0xaa.toByte)
  val array3byte6seq = Array[Byte](0xdb.toByte, 0xdb.toByte, 0xdb.toByte, 0x24.toByte, 0x24.toByte, 0x24.toByte)
  val array3byte7seq = Array[Byte](0x24.toByte, 0x24.toByte, 0x24.toByte, 0xdb.toByte, 0xdb.toByte, 0xdb.toByte)
  val array3byte8seq = Array[Byte](0xdb.toByte, 0xdb.toByte, 0x00.toByte, 0x24.toByte, 0x24.toByte, 0x00.toByte)
  val array3byte9seq = Array[Byte](0xdb.toByte, 0xdb.toByte, 0x00.toByte, 0x24.toByte, 0x24.toByte, 0x00.toByte)
  val array3byte10seq = Array[Byte](0x24.toByte, 0x24.toByte, 0x00.toByte, 0xdb.toByte, 0xdb.toByte, 0x00.toByte)

  val header2byte = Array[Byte](0x52.toByte, 0x49.toByte, 0x46.toByte, 0x46.toByte, 0xF0.toByte, 0xFD.toByte, 0x4E.toByte, 0x06.toByte, 0x57.toByte, 0x41.toByte,
    0x56.toByte, 0x45.toByte, 0x66.toByte, 0x6D.toByte, 0x74.toByte, 0x20.toByte, 0x10.toByte, 0x00.toByte, 0x00.toByte, 0x00.toByte, 0x01.toByte, 0x00.toByte,
    0x02.toByte, 0x00.toByte, 0x44.toByte, 0xAC.toByte, 0x00.toByte, 0x00.toByte, 0x10.toByte, 0xB1.toByte, 0x02.toByte, 0x00.toByte, 0x04.toByte, 0x00.toByte,
    0x10.toByte, 0x00.toByte, 0x64.toByte, 0x61.toByte, 0x74.toByte, 0x61.toByte, 0x80.toByte, 0xFD.toByte, 0x4E.toByte, 0x06.toByte)

  val header3byte = Array[Byte](0x52.toByte, 0x49.toByte, 0x46.toByte, 0x46.toByte, 0xB0.toByte, 0x7C.toByte, 0x76.toByte, 0x09.toByte, 0x57.toByte, 0x41.toByte,
    0x56.toByte, 0x45.toByte, 0x66.toByte, 0x6D.toByte, 0x74.toByte,
    0x20.toByte, 0x10.toByte, 0x00.toByte, 0x00.toByte, 0x00.toByte, 0x01.toByte, 0x00.toByte, 0x02.toByte, 0x00.toByte, 0x44.toByte, 0xAC.toByte, 0x00.toByte,
    0x00.toByte, 0x98.toByte, 0x09.toByte, 0x04.toByte, 0x00.toByte, 0x06.toByte, 0x00.toByte,
    0x18.toByte, 0x00.toByte, 0x64.toByte, 0x61.toByte, 0x74.toByte, 0x61.toByte, 0x40.toByte, 0x7C.toByte, 0x76.toByte, 0x09.toByte)

  val footer2byte = Array[Byte](0x4C.toByte, 0x49.toByte, 0x53.toByte, 0x54.toByte, 0x44.toByte, 0x00.toByte, 0x00.toByte, 0x00.toByte, 0x49.toByte,
    0x4E.toByte, 0x46.toByte, 0x4F.toByte, 0x49.toByte, 0x43.toByte, 0x52.toByte, 0x44.toByte, 0x0B.toByte, 0x00.toByte, 0x00.toByte, 0x00.toByte, 0x32.toByte, 0x30.toByte,
    0x31.toByte, 0x38.toByte, 0x2D.toByte, 0x30.toByte, 0x38.toByte, 0x2D.toByte, 0x32.toByte,
    0x34.toByte, 0x00.toByte, 0x00.toByte, 0x49.toByte, 0x45.toByte, 0x4E.toByte, 0x47.toByte, 0x06.toByte, 0x00.toByte, 0x00.toByte, 0x00.toByte, 0x20.toByte,
    0x55.toByte, 0x73.toByte, 0x65.toByte, 0x72.toByte, 0x00.toByte, 0x49.toByte,
    0x53.toByte, 0x46.toByte, 0x54.toByte, 0x15.toByte, 0x00.toByte, 0x00.toByte, 0x00.toByte, 0x53.toByte, 0x6F.toByte, 0x75.toByte, 0x6E.toByte, 0x64.toByte,
    0x20.toByte, 0x46.toByte, 0x6F.toByte, 0x72.toByte, 0x67.toByte, 0x65.toByte,
    0x20.toByte, 0x50.toByte, 0x72.toByte, 0x6F.toByte, 0x20.toByte, 0x31.toByte, 0x31.toByte, 0x2E.toByte, 0x30.toByte, 0x00.toByte, 0x02.toByte)

  val footer3byte = Array[Byte](0x4C.toByte, 0x49.toByte, 0x53.toByte, 0x54.toByte, 0x44.toByte, 0x00.toByte, 0x00.toByte, 0x00.toByte, 0x49.toByte,
    0x4E.toByte, 0x46.toByte, 0x4F.toByte, 0x49.toByte, 0x43.toByte, 0x52.toByte, 0x44.toByte, 0x0B.toByte, 0x00.toByte, 0x00.toByte, 0x00.toByte, 0x32.toByte, 0x30.toByte,
    0x31.toByte, 0x38.toByte, 0x2D.toByte, 0x30.toByte, 0x38.toByte, 0x2D.toByte, 0x32.toByte, 0x34.toByte, 0x00.toByte, 0x00.toByte, 0x49.toByte, 0x45.toByte, 0x4E.toByte,
    0x47.toByte, 0x06.toByte, 0x00.toByte, 0x00.toByte, 0x00.toByte, 0x20.toByte, 0x55.toByte, 0x73.toByte, 0x65.toByte, 0x72.toByte, 0x00.toByte, 0x49.toByte, 0x53.toByte,
    0x46.toByte, 0x54.toByte, 0x15.toByte, 0x00.toByte, 0x00.toByte, 0x00.toByte, 0x53.toByte, 0x6F.toByte, 0x75.toByte, 0x6E.toByte, 0x64.toByte, 0x20.toByte, 0x46.toByte,
    0x6F.toByte, 0x72.toByte, 0x67.toByte, 0x65.toByte, 0x20.toByte, 0x50.toByte, 0x72.toByte, 0x6F.toByte, 0x20.toByte, 0x31.toByte, 0x31.toByte, 0x2E.toByte, 0x30.toByte,
    0x00.toByte, 0x02.toByte)

  val arr2bytesseq = Array(array2byte1seq, array2byte2seq, array2byte3seq, array2byte4seq,
  array2byte5seq, array2byte6seq)

  val arr3bytesseq = Array(array3byte1seq, array3byte2seq, array3byte3seq, array3byte4seq,
  array3byte5seq, array3byte6seq, array3byte7seq, array3byte8seq, array3byte9seq,
  array3byte10seq)

  val arr2names = Array("44_16Bit_1.wav", "44_16Bit_2.wav", "44_16Bit_3.wav",
  "44_16Bit_4.wav", "44_16Bit_5.wav", "44_16Bit_6.wav")

  val arr3names = Array("44_24Bit_1.wav", "44_24Bit_2.wav", "44_24Bit_3.wav",
  "44_24Bit_4.wav", "44_24Bit_5.wav", "44_24Bit_6.wav", "44_24Bit_7.wav",
  "44_24Bit_8.wav", "44_24Bit_9.wav", "44_24Bit_10.wav")

  val template2byte = "44_16Bit.wav"
  val template3byte = "44_24Bit.wav"
  val startTime = System.currentTimeMillis
  for (i <-1 to 10){
    if (i<7)
      createfile(template2byte, arr2bytesseq(i - 1), header2byte, footer2byte, arr2names(i - 1))
    createfile(template3byte, arr3bytesseq(i - 1), header3byte, footer3byte, arr3names(i - 1))
  }
  val stopTime = System.currentTimeMillis
  val elapsedTime = stopTime - startTime
  System.out.println("total=" + elapsedTime / 1000 + "   Sekunden")
}