using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace tamrine_11
{
    public partial class bill : Form
    {
        string temp2 = "";
        string temp = "";
        string fileasli = "";
        int isexist = 0;
        public bill()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (File.Exists("bill.txt"))
            {
                FileStream fs = new FileStream("bill.txt", FileMode.Open, FileAccess.Read);
                StreamReader sr = new StreamReader(fs);
                FileStream fs2 = new FileStream("billtemp.txt", FileMode.Append, FileAccess.Write);
                StreamWriter sw = new StreamWriter(fs2);
                temp = sr.ReadLine();
                while (temp != null)
                {
                    string[] element = temp.Split(',');
                    if (element[0] == tb1.Text)
                    {
                        fileasli = tb1.Text + "," + tb2.Text + "," + element[3] + "," + tb3.Text + "," + element[5] + "," + tb4.Text + "," + tb5.Text;
                        isexist = 1;
                    }
                    else
                    {
                        sw.WriteLine(temp);
                    }
                    temp = sr.ReadLine();
                }
                sw.Close();
                fs2.Close();
                fs.Close();
                sr.Close();

            }
            if (isexist == 1)
            {
                if (File.Exists("billtemp.txt"))
                {
                    File.Delete("bill.txt");
                    FileStream fs = new FileStream("bill.txt", FileMode.Append, FileAccess.Write);
                    StreamWriter sw = new StreamWriter(fs);
                    FileStream fs2 = new FileStream("billtemp.txt", FileMode.Open, FileAccess.Read);
                    StreamReader sr = new StreamReader(fs2);
                    temp2 = sr.ReadLine();
                    while (temp2 != null)
                    {
                        sw.WriteLine(temp2);
                        temp2 = sr.ReadLine();

                    }
                    sw.WriteLine(fileasli);
                    sr.Close();
                    fs2.Close();
                    sw.Close();
                    fs.Close();
                }

            }
            else
            {
                FileStream fs = new FileStream("bill.txt", FileMode.Append, FileAccess.Write);
                StreamWriter sw = new StreamWriter(fs);
                fileasli = tb1.Text + "," + tb2.Text + "," + "" + "," + tb3.Text + "," + "0" + "," + tb4.Text + "," + tb5.Text;
                sw.WriteLine(fileasli);
                sw.Close();
                fs.Close();
            }
            File.Delete("billtemp.txt");
            MessageBox.Show("update file billing anjam shod");
        }
    }
}
