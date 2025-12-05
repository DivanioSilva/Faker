package au.com.anthonybruno.creator;

import au.com.anthonybruno.record.RecordSupplier;
import au.com.anthonybruno.record.factory.RecordFactory;
import au.com.anthonybruno.settings.FixedWidthSettings;
import au.com.anthonybruno.utils.TextFile;
import au.com.anthonybruno.writer.CsvWriterFactory;
import au.com.anthonybruno.writer.fixedwidth.AbstractFixedWidthWriter;

import java.io.File;
import java.io.StringWriter;

public class FixedWidthFactory extends FlatFileFactory<FixedWidthSettings> {

    public FixedWidthFactory(FixedWidthSettings settings, RecordFactory recordFactory) {
        super(settings, recordFactory);
    }

    @Override
    public String createString(int numToGenerate) {
        StringWriter stringWriter = new StringWriter();
        try (AbstractFixedWidthWriter fixedWidthWriter = CsvWriterFactory.getDefaultFixedWidthWriter(stringWriter, settings)) {
            generateAndWriteValues(fixedWidthWriter, numToGenerate);
        }
        return stringWriter.toString();
    }


    private void generateAndWriteValues(AbstractFixedWidthWriter writer, int numToGenerate) {
        RecordSupplier recordSupplier = recordFactory.getRecordSupplier();
        if (settings.isIncludingHeaders()) {
            writer.writeRow(recordSupplier.getFields());
        }
        recordSupplier.supplyRecords(numToGenerate)
                .forEach(record -> {
                    writer.writeRecord(record);
                });
    }

    @Override
    public File createFile(File file, int numToGenerate) {
        try (AbstractFixedWidthWriter fixedWidthWriter = CsvWriterFactory.getDefaultFixedWidthWriter(new TextFile(file).getWriter(), settings)) {
            generateAndWriteValues(fixedWidthWriter, numToGenerate);
        }
        return file;
    }
}
