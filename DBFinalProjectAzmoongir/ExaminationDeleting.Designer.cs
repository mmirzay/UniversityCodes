namespace Azmoongir
{
    partial class ExaminationDeleting
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
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.rtxtCrsCode = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.rtxtExamType = new System.Windows.Forms.TextBox();
            this.cmbExamMajor = new System.Windows.Forms.ComboBox();
            this.label2 = new System.Windows.Forms.Label();
            this.cmbExamCode = new System.Windows.Forms.ComboBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.btnCancel = new System.Windows.Forms.Button();
            this.btnDel = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.rtxtCrsCode);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.rtxtExamType);
            this.groupBox1.Controls.Add(this.cmbExamMajor);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.cmbExamCode);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Location = new System.Drawing.Point(3, 0);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(554, 106);
            this.groupBox1.TabIndex = 2;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "انتخاب آزمون";
            // 
            // rtxtCrsCode
            // 
            this.rtxtCrsCode.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.rtxtCrsCode.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.rtxtCrsCode.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rtxtCrsCode.ForeColor = System.Drawing.Color.Yellow;
            this.rtxtCrsCode.Location = new System.Drawing.Point(31, 62);
            this.rtxtCrsCode.Name = "rtxtCrsCode";
            this.rtxtCrsCode.ReadOnly = true;
            this.rtxtCrsCode.Size = new System.Drawing.Size(167, 27);
            this.rtxtCrsCode.TabIndex = 19;
            this.rtxtCrsCode.TabStop = false;
            this.rtxtCrsCode.Text = "کد آزمون را انتخاب کنید";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.Location = new System.Drawing.Point(204, 69);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(73, 20);
            this.label1.TabIndex = 18;
            this.label1.Text = "کد درس :";
            // 
            // rtxtExamType
            // 
            this.rtxtExamType.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.rtxtExamType.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
            this.rtxtExamType.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.rtxtExamType.ForeColor = System.Drawing.Color.Yellow;
            this.rtxtExamType.Location = new System.Drawing.Point(283, 62);
            this.rtxtExamType.Name = "rtxtExamType";
            this.rtxtExamType.ReadOnly = true;
            this.rtxtExamType.Size = new System.Drawing.Size(167, 27);
            this.rtxtExamType.TabIndex = 17;
            this.rtxtExamType.TabStop = false;
            this.rtxtExamType.Text = "کد آزمون را انتخاب کنید";
            // 
            // cmbExamMajor
            // 
            this.cmbExamMajor.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbExamMajor.Enabled = false;
            this.cmbExamMajor.FormattingEnabled = true;
            this.cmbExamMajor.Location = new System.Drawing.Point(31, 27);
            this.cmbExamMajor.Name = "cmbExamMajor";
            this.cmbExamMajor.Size = new System.Drawing.Size(167, 24);
            this.cmbExamMajor.TabIndex = 2;
            this.cmbExamMajor.SelectedIndexChanged += new System.EventHandler(this.cmbExamMajor_SelectedIndexChanged);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(455, 64);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(90, 20);
            this.label2.TabIndex = 15;
            this.label2.Text = "نوع آزمون :";
            // 
            // cmbExamCode
            // 
            this.cmbExamCode.DropDownStyle = System.Windows.Forms.ComboBoxStyle.DropDownList;
            this.cmbExamCode.FormattingEnabled = true;
            this.cmbExamCode.Location = new System.Drawing.Point(283, 27);
            this.cmbExamCode.Name = "cmbExamCode";
            this.cmbExamCode.Size = new System.Drawing.Size(167, 24);
            this.cmbExamCode.TabIndex = 1;
            this.cmbExamCode.SelectedIndexChanged += new System.EventHandler(this.cmbExamCode_SelectedIndexChanged);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(225, 27);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(52, 20);
            this.label4.TabIndex = 13;
            this.label4.Text = "رشته :";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(463, 27);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(82, 20);
            this.label3.TabIndex = 12;
            this.label3.Text = "کد آزمون :";
            // 
            // btnCancel
            // 
            this.btnCancel.AutoSize = true;
            this.btnCancel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnCancel.Location = new System.Drawing.Point(389, 112);
            this.btnCancel.Name = "btnCancel";
            this.btnCancel.Size = new System.Drawing.Size(81, 30);
            this.btnCancel.TabIndex = 21;
            this.btnCancel.Text = "انصراف";
            this.btnCancel.UseVisualStyleBackColor = true;
            // 
            // btnDel
            // 
            this.btnDel.AutoSize = true;
            this.btnDel.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnDel.Location = new System.Drawing.Point(476, 112);
            this.btnDel.Name = "btnDel";
            this.btnDel.Size = new System.Drawing.Size(81, 30);
            this.btnDel.TabIndex = 20;
            this.btnDel.Text = "حذف";
            this.btnDel.UseVisualStyleBackColor = true;
            this.btnDel.Click += new System.EventHandler(this.btnDel_Click);
            // 
            // ExaminationDeleting
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(561, 148);
            this.Controls.Add(this.btnCancel);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.btnDel);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "ExaminationDeleting";
            this.RightToLeft = System.Windows.Forms.RightToLeft.Yes;
            this.Text = "حذف آزمون";
            this.Load += new System.EventHandler(this.ExaminationDeleting_Load);
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TextBox rtxtCrsCode;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.TextBox rtxtExamType;
        private System.Windows.Forms.ComboBox cmbExamMajor;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.ComboBox cmbExamCode;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button btnCancel;
        private System.Windows.Forms.Button btnDel;
    }
}