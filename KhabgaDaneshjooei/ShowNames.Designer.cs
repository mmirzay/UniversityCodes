namespace KhabgaDaneshjooei
{
    partial class ShowNames
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle1 = new System.Windows.Forms.DataGridViewCellStyle();
            System.Windows.Forms.DataGridViewCellStyle dataGridViewCellStyle2 = new System.Windows.Forms.DataGridViewCellStyle();
            this.dtg = new System.Windows.Forms.DataGridView();
            this.btnEnseraf = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dtg)).BeginInit();
            this.SuspendLayout();
            // 
            // dtg
            // 
            dataGridViewCellStyle1.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(192)))), ((int)(((byte)(255)))), ((int)(((byte)(255)))));
            dataGridViewCellStyle1.Font = new System.Drawing.Font("Microsoft Sans Serif", 7.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.dtg.AlternatingRowsDefaultCellStyle = dataGridViewCellStyle1;
            dataGridViewCellStyle2.Alignment = System.Windows.Forms.DataGridViewContentAlignment.MiddleLeft;
            dataGridViewCellStyle2.BackColor = System.Drawing.SystemColors.Control;
            dataGridViewCellStyle2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            dataGridViewCellStyle2.ForeColor = System.Drawing.SystemColors.WindowText;
            dataGridViewCellStyle2.SelectionBackColor = System.Drawing.SystemColors.Highlight;
            dataGridViewCellStyle2.SelectionForeColor = System.Drawing.SystemColors.HighlightText;
            dataGridViewCellStyle2.WrapMode = System.Windows.Forms.DataGridViewTriState.True;
            this.dtg.ColumnHeadersDefaultCellStyle = dataGridViewCellStyle2;
            this.dtg.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dtg.Location = new System.Drawing.Point(12, 12);
            this.dtg.Name = "dtg";
            this.dtg.ReadOnly = true;
            this.dtg.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.dtg.RowTemplate.Height = 24;
            this.dtg.Size = new System.Drawing.Size(745, 283);
            this.dtg.TabIndex = 0;
            this.dtg.CellContentClick += new System.Windows.Forms.DataGridViewCellEventHandler(this.dtg_CellContentClick);
            // 
            // btnEnseraf
            // 
            this.btnEnseraf.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEnseraf.Location = new System.Drawing.Point(682, 310);
            this.btnEnseraf.Name = "btnEnseraf";
            this.btnEnseraf.Size = new System.Drawing.Size(75, 26);
            this.btnEnseraf.TabIndex = 6;
            this.btnEnseraf.Text = "خروج";
            this.btnEnseraf.UseVisualStyleBackColor = true;
            this.btnEnseraf.Click += new System.EventHandler(this.btnEnseraf_Click);
            // 
            // ShowNames
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(768, 345);
            this.Controls.Add(this.btnEnseraf);
            this.Controls.Add(this.dtg);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "ShowNames";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Text = "لیست اسامی";
            this.Load += new System.EventHandler(this.ShowNames_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dtg)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dtg;
        private System.Windows.Forms.Button btnEnseraf;
    }
}