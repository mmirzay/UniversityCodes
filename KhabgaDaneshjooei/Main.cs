using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.IO;

namespace KhabgaDaneshjooei
{
    public partial class Main : Form
    {
        public Main()
        {
            InitializeComponent();
        }

        private void مشخصاتدانشجوToolStripMenuItem_Click(object sender, EventArgs e)
        {            
            new StudentProperties().ShowDialog();            
        }

        private void اتاقهایخوابگاهToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Rooms().ShowDialog();
        }

        private void تحویلاتاقبهدانشجوToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new RoomToStudent().ShowDialog();
        }

        private void Main_Load(object sender, EventArgs e)
        {
            File.AppendText("RoomsMember.txt").Close() ;
            File.AppendText("EnterDate.txt").Close();
            new UserPass().ShowDialog();
        }

        private void سالورودوخروجToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new YearEnter().ShowDialog();
        }        

        private void متعلقاتدانشجوToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new App().ShowDialog();
        }

        private void تخلفاتدانشجوToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Inf().ShowDialog();
        }

        private void ضامنToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new Spr().ShowDialog();
        }

        private void دانشجویانخوابگاهToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new ShowNames().ShowDialog();
        }

        private void اعضایاتاقToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new ShowMembers().ShowDialog();
        }

        private void ساعتورودوخروجدانشجوToolStripMenuItem_Click(object sender, EventArgs e)
        {
            new ShowDates().ShowDialog();
        }
    }
}
