 import org.apache.hadoop.fs.Path;
    import org.apache.hadoop.io.*;
    import org.apache.hadoop.mapred.*;
    
    public class serviceRequestMain{
        
      public static void main(String[] args) throws Exception {
        JobConf job = new JobConf(crimeScoreMain.class);
        job.setJobName("sanitationScore");
        
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
 
        job.setInputFormat(TextInputFormat.class);
        job.setOutputFormat(TextOutputFormat.class);
     
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);
 
        job.setMapperClass(serviceRequestMapper.class);
        job.setReducerClass(serviceRequestReducer.class);
    
        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
 
        JobClient.runJob(job);
      }
    }